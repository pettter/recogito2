define([
  'common/config',
  'common/hasEvents',
  'document/annotation/text/relations/edit/hoverEmphasis',
  'document/annotation/text/relations/connection'
], function(Config, HasEvents, HoverEmphasis, Connection) {

      /**
       * Helper: gets all stacked annotation SPANS for an element.
       *
       * Reminder - annotations can be nested. This helper retrieves the whole stack.
       *
       * <span class="annotation" data-id="annotation-01">
       *   <span class="annotation" data-id="annotation-02">
       *     <span class="annotation" data-id="annotation-03">foo</span>
       *   </span>
       * </span>
       */
  var getAnnotationSpansRecursive = function(element, a) {
        var spans = (a) ? a : [ ],
            parent = element.parentNode;

        spans.push(element);

        if (jQuery(parent).hasClass('annotation'))
          return getAnnotationSpansRecursive(parent, spans);
        else
          return spans;
      },

      /**
       * Returns a 'graph node' object { annotation: ..., elements: ... } for the
       * given mouse event. (Used for mouse over emphasis effect.)
       */
      toNode = function(e) {
        var t = jQuery(e.target).closest('.annotation'),
            sourceSpan = (t.length > 0) ? t[0] : undefined,
            annotationSpans, annotation, elements;

        if (sourceSpan) {
          // All stacked annotation spans
          annotationSpans = getAnnotationSpansRecursive(sourceSpan);

          // Annotation ID from the top-most span in the stack
          annotation = annotationSpans[annotationSpans.length - 1].annotation;

          // ALL spans for this annotation (not just the hovered one)
          elements = jQuery('.annotation[data-id="' + annotation.annotation_id + '"]');

          return { annotation: annotation, elements: elements };
        }

      };

  var RelationEditor = function(content, svg) {

    var that = this,

        contentEl = jQuery(content),

        currentHover = false,

        currentConnection = false,

        attachHandlers = function() {
          contentEl.addClass('noselect');
          contentEl.on('mousedown', onMousedown);
          contentEl.on('mousemove', onMousemove);
          contentEl.on('mouseup', onMouseup);
          contentEl.on('mouseover', '.annotation', onEnterAnnotation);
          contentEl.on('mouseleave', '.annotation', onLeaveAnnotation);
        },

        detachHandlers = function() {
          contentEl.removeClass('noselect');
          contentEl.off('mousedown', onMousedown);
          contentEl.off('mousemove', onMousemove);
          contentEl.off('mouseup', onMouseup);
          contentEl.off('mouseover', '.annotation', onEnterAnnotation);
          contentEl.off('mouseleave', '.annotation', onLeaveAnnotation);
        },

        /** Drawing code for 'hover emphasis' **/
        hover = function(elements) {
          if (elements) {
            currentHover = new HoverEmphasis(svg, elements);
          } else { // Clear hover
            if (currentHover) currentHover.destroy();
            currentHover = undefined;
          }
        },

        /** Emphasise hovered annotation **/
        onEnterAnnotation = function(e) {
          if (currentHover) hover();
          hover(toNode(e).elements);
        },

        /** Clear hover emphasis **/
        onLeaveAnnotation = function(e) {
          hover();
        },

        /** Starts or creates a new relation **/
        onMousedown = function(e) {
          var node = toNode(e);
          if (node) {
            if (currentConnection) completeConnection(node);
            else startNewConnection(node);
          }
        },

        onMousemove = function(e) {
          if (currentConnection && currentConnection.isFloating()) {
            if (currentHover)  {
              currentConnection.dragTo(currentHover.node);
            } else {
              var offset = contentEl.offset();
              currentConnection.dragTo([ e.pageX - offset.left, e.pageY - offset.top ]);
            }
          }
        },

        /**
         * Note: we want to support both possible drawing modes: click once for start + once for
         * end; or click and hold at the start, drag to end and release.
         */
        onMouseup = function(e) {
          if (currentHover && currentConnection && currentConnection.isFloating()) {
            // If this is a different node than the start node, complete the connection
            if (currentHover.annotation !== currentConnection.getStartAnnotation())
              completeConnection(currentHover.node);
          }
        },

        /** Start drawing a new connection line **/
        startNewConnection = function(fromNode) {
          currentConnection = new Connection(content, svg, fromNode);
          jQuery(document.body).css('cursor', 'none');
          render();
        },

        /** Complete drawing of a new connection **/
        completeConnection = function() {

              // Adds a relation, or replaces an existing one if any exists with the same end node
          var addOrReplaceRelation = function(annotation, relation) {
                if (!annotation.relations) annotation.relations = [];

                var existing = annotation.relations.filter(function(r) {
                  return r.relates_to === relation.relates_to;
                });

                if (existing.length > 0)
                  annotation.relations[annotation.relations.indexOf(existing)] = relation;
                else
                  annotation.relations.push(relation);
              },

              onUpdate = function(annotation, connection) {
                that.fireEvent('updateRelations', annotation);
                currentConnection = undefined;
              },

              onDelete = function(connection) {
                currentConnection = undefined;
                that.fireEvent('delete', connection);
              },

              onCancel = function() {
                currentConnection = undefined;
              };

          currentConnection.fix();
          currentConnection.on('update', onUpdate);
          currentConnection.on('delete', onDelete);
          currentConnection.on('cancel', onCancel);
          currentConnection.editRelation();

          jQuery(document.body).css('cursor', 'auto');
        },

        render = function() {
          if (currentConnection) {
            currentConnection.redraw();
            requestAnimationFrame(render);
          }
        },

        setEnabled = function(enabled) {
          if (enabled) attachHandlers();
          else detachHandlers();
        };

    this.setEnabled = setEnabled;

    HasEvents.apply(this);
  };
  RelationEditor.prototype = Object.create(HasEvents.prototype);

  return RelationEditor;

});
