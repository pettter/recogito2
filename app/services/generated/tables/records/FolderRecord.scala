/**
 * This class is generated by jOOQ
 */
package services.generated.tables.records


import java.lang.String
import java.util.UUID

import javax.annotation.Generated

import org.jooq.Field
import org.jooq.Record1
import org.jooq.Record7
import org.jooq.Row7
import org.jooq.impl.UpdatableRecordImpl

import services.generated.tables.Folder


/**
 * This class is generated by jOOQ.
 */
@Generated(
	value = Array(
		"http://www.jooq.org",
		"jOOQ version:3.7.2"
	),
	comments = "This class is generated by jOOQ"
)
class FolderRecord extends UpdatableRecordImpl[FolderRecord](Folder.FOLDER) with Record7[UUID, String, String, UUID, String, String, String] {

	/**
	 * Setter for <code>public.folder.id</code>.
	 */
	def setId(value : UUID) : Unit = {
		setValue(0, value)
	}

	/**
	 * Getter for <code>public.folder.id</code>.
	 */
	def getId : UUID = {
		val r = getValue(0)
		if (r == null) null else r.asInstanceOf[UUID]
	}

	/**
	 * Setter for <code>public.folder.owner</code>.
	 */
	def setOwner(value : String) : Unit = {
		setValue(1, value)
	}

	/**
	 * Getter for <code>public.folder.owner</code>.
	 */
	def getOwner : String = {
		val r = getValue(1)
		if (r == null) null else r.asInstanceOf[String]
	}

	/**
	 * Setter for <code>public.folder.title</code>.
	 */
	def setTitle(value : String) : Unit = {
		setValue(2, value)
	}

	/**
	 * Getter for <code>public.folder.title</code>.
	 */
	def getTitle : String = {
		val r = getValue(2)
		if (r == null) null else r.asInstanceOf[String]
	}

	/**
	 * Setter for <code>public.folder.parent</code>.
	 */
	def setParent(value : UUID) : Unit = {
		setValue(3, value)
	}

	/**
	 * Getter for <code>public.folder.parent</code>.
	 */
	def getParent : UUID = {
		val r = getValue(3)
		if (r == null) null else r.asInstanceOf[UUID]
	}

	/**
	 * Setter for <code>public.folder.readme</code>.
	 */
	def setReadme(value : String) : Unit = {
		setValue(4, value)
	}

	/**
	 * Getter for <code>public.folder.readme</code>.
	 */
	def getReadme : String = {
		val r = getValue(4)
		if (r == null) null else r.asInstanceOf[String]
	}

	/**
	 * Setter for <code>public.folder.public_visibility</code>.
	 */
	def setPublicVisibility(value : String) : Unit = {
		setValue(5, value)
	}

	/**
	 * Getter for <code>public.folder.public_visibility</code>.
	 */
	def getPublicVisibility : String = {
		val r = getValue(5)
		if (r == null) null else r.asInstanceOf[String]
	}

	/**
	 * Setter for <code>public.folder.public_access_level</code>.
	 */
	def setPublicAccessLevel(value : String) : Unit = {
		setValue(6, value)
	}

	/**
	 * Getter for <code>public.folder.public_access_level</code>.
	 */
	def getPublicAccessLevel : String = {
		val r = getValue(6)
		if (r == null) null else r.asInstanceOf[String]
	}

	// -------------------------------------------------------------------------
	// Primary key information
	// -------------------------------------------------------------------------
	override def key() : Record1[UUID] = {
		return super.key.asInstanceOf[ Record1[UUID] ]
	}

	// -------------------------------------------------------------------------
	// Record7 type implementation
	// -------------------------------------------------------------------------

	override def fieldsRow : Row7[UUID, String, String, UUID, String, String, String] = {
		super.fieldsRow.asInstanceOf[ Row7[UUID, String, String, UUID, String, String, String] ]
	}

	override def valuesRow : Row7[UUID, String, String, UUID, String, String, String] = {
		super.valuesRow.asInstanceOf[ Row7[UUID, String, String, UUID, String, String, String] ]
	}
	override def field1 : Field[UUID] = Folder.FOLDER.ID
	override def field2 : Field[String] = Folder.FOLDER.OWNER
	override def field3 : Field[String] = Folder.FOLDER.TITLE
	override def field4 : Field[UUID] = Folder.FOLDER.PARENT
	override def field5 : Field[String] = Folder.FOLDER.README
	override def field6 : Field[String] = Folder.FOLDER.PUBLIC_VISIBILITY
	override def field7 : Field[String] = Folder.FOLDER.PUBLIC_ACCESS_LEVEL
	override def value1 : UUID = getId
	override def value2 : String = getOwner
	override def value3 : String = getTitle
	override def value4 : UUID = getParent
	override def value5 : String = getReadme
	override def value6 : String = getPublicVisibility
	override def value7 : String = getPublicAccessLevel

	override def value1(value : UUID) : FolderRecord = {
		setId(value)
		this
	}

	override def value2(value : String) : FolderRecord = {
		setOwner(value)
		this
	}

	override def value3(value : String) : FolderRecord = {
		setTitle(value)
		this
	}

	override def value4(value : UUID) : FolderRecord = {
		setParent(value)
		this
	}

	override def value5(value : String) : FolderRecord = {
		setReadme(value)
		this
	}

	override def value6(value : String) : FolderRecord = {
		setPublicVisibility(value)
		this
	}

	override def value7(value : String) : FolderRecord = {
		setPublicAccessLevel(value)
		this
	}

	override def values(value1 : UUID, value2 : String, value3 : String, value4 : UUID, value5 : String, value6 : String, value7 : String) : FolderRecord = {
		this.value1(value1)
		this.value2(value2)
		this.value3(value3)
		this.value4(value4)
		this.value5(value5)
		this.value6(value6)
		this.value7(value7)
		this
	}

	/**
	 * Create a detached, initialised FolderRecord
	 */
	def this(id : UUID, owner : String, title : String, parent : UUID, readme : String, publicVisibility : String, publicAccessLevel : String) = {
		this()

		setValue(0, id)
		setValue(1, owner)
		setValue(2, title)
		setValue(3, parent)
		setValue(4, readme)
		setValue(5, publicVisibility)
		setValue(6, publicAccessLevel)
	}
}
