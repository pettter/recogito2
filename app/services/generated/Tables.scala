/**
 * This class is generated by jOOQ
 */
package services.generated


import javax.annotation.Generated

import services.generated.tables.AuthorityFile
import services.generated.tables.Document
import services.generated.tables.DocumentFilepart
import services.generated.tables.DocumentPreferences
import services.generated.tables.FeatureToggle
import services.generated.tables.Folder
import services.generated.tables.FolderAssociation
import services.generated.tables.ServiceAnnouncement
import services.generated.tables.SharingPolicy
import services.generated.tables.Task
import services.generated.tables.Upload
import services.generated.tables.UploadFilepart
import services.generated.tables.User
import services.generated.tables.UserRole


/**
 * Convenience access to all tables in public
 */
@Generated(
	value = Array(
		"http://www.jooq.org",
		"jOOQ version:3.7.2"
	),
	comments = "This class is generated by jOOQ"
)
object Tables {

	/**
	 * The table public.authority_file
	 */
	val AUTHORITY_FILE = services.generated.tables.AuthorityFile.AUTHORITY_FILE

	/**
	 * The table public.document
	 */
	val DOCUMENT = services.generated.tables.Document.DOCUMENT

	/**
	 * The table public.document_filepart
	 */
	val DOCUMENT_FILEPART = services.generated.tables.DocumentFilepart.DOCUMENT_FILEPART

	/**
	 * The table public.document_preferences
	 */
	val DOCUMENT_PREFERENCES = services.generated.tables.DocumentPreferences.DOCUMENT_PREFERENCES

	/**
	 * The table public.feature_toggle
	 */
	val FEATURE_TOGGLE = services.generated.tables.FeatureToggle.FEATURE_TOGGLE

	/**
	 * The table public.folder
	 */
	val FOLDER = services.generated.tables.Folder.FOLDER

	/**
	 * The table public.folder_association
	 */
	val FOLDER_ASSOCIATION = services.generated.tables.FolderAssociation.FOLDER_ASSOCIATION

	/**
	 * The table public.service_announcement
	 */
	val SERVICE_ANNOUNCEMENT = services.generated.tables.ServiceAnnouncement.SERVICE_ANNOUNCEMENT

	/**
	 * The table public.sharing_policy
	 */
	val SHARING_POLICY = services.generated.tables.SharingPolicy.SHARING_POLICY

	/**
	 * The table public.task
	 */
	val TASK = services.generated.tables.Task.TASK

	/**
	 * The table public.upload
	 */
	val UPLOAD = services.generated.tables.Upload.UPLOAD

	/**
	 * The table public.upload_filepart
	 */
	val UPLOAD_FILEPART = services.generated.tables.UploadFilepart.UPLOAD_FILEPART

	/**
	 * The table public.user
	 */
	val USER = services.generated.tables.User.USER

	/**
	 * The table public.user_role
	 */
	val USER_ROLE = services.generated.tables.UserRole.USER_ROLE
}
