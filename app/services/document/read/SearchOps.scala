package services.document.read

import org.jooq.impl.DSL._
import services.PublicAccess
import services.document.DocumentService
import services.generated.tables.records.DocumentRecord
import services.generated.Tables.{SHARING_POLICY, DOCUMENT}

trait SearchOps { self: DocumentService => 

  def searchAll(loggedInAs: Option[String], query: String) = db.query { sql => 
    loggedInAs match {
      case Some(username) => 
        // Public documents + mine + shared with me
        sql.select().from(DOCUMENT)
           .leftOuterJoin(SHARING_POLICY)
             .on(SHARING_POLICY.DOCUMENT_ID.equal(DOCUMENT.ID))
             .and(SHARING_POLICY.SHARED_WITH.equal(username))
           .where(
             DOCUMENT.OWNER.equal(username)
               .or(SHARING_POLICY.SHARED_WITH.equal(username))
               .or(DOCUMENT.PUBLIC_VISIBILITY.equal(PublicAccess.PUBLIC.toString))
           ).and(lower(DOCUMENT.TITLE).like(s"%${query.toLowerCase}%"))
           .fetchArray.map(_.into(classOf[DocumentRecord]))
           .toSeq

      case None => 
        // Public documents only
        sql.selectFrom(DOCUMENT)
           .where(DOCUMENT.PUBLIC_VISIBILITY.equal(PublicAccess.PUBLIC.toString))
             .and(lower(DOCUMENT.TITLE).like(s"%${query.toLowerCase}%"))
           .fetchArray
           .toSeq
    }
  }

  def searchMyDocuments(username: String, query: String) = db.query { sql =>
    sql.selectFrom(DOCUMENT)
       .where(DOCUMENT.OWNER.equal(username))
         .and(lower(DOCUMENT.TITLE).like(s"%${query.toLowerCase}%"))
       .fetchArray
       .toSeq
  }

  def searchSharedWithMe(username: String, query: String) = db.query { sql =>
    sql.select().from(SHARING_POLICY)
       .join(DOCUMENT)
         .on(DOCUMENT.ID.equal(SHARING_POLICY.DOCUMENT_ID))
       .where(SHARING_POLICY.SHARED_WITH.equal(username))
         .and(lower(DOCUMENT.TITLE).like(s"%${query.toLowerCase}%"))
       .fetchArray.map(_.into(classOf[DocumentRecord]))
       .toSeq
  }

}