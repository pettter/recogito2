/**
 * This class is generated by jOOQ
 */
package services.generated.tables


import java.lang.Class
import java.lang.Integer
import java.lang.String
import java.util.Arrays
import java.util.List

import javax.annotation.Generated

import org.jooq.Field
import org.jooq.ForeignKey
import org.jooq.Identity
import org.jooq.Table
import org.jooq.TableField
import org.jooq.UniqueKey
import org.jooq.impl.TableImpl

import services.generated.Keys
import services.generated.Public
import services.generated.tables.records.DocumentPreferencesRecord


object DocumentPreferences {

	/**
	 * The reference instance of <code>public.document_preferences</code>
	 */
	val DOCUMENT_PREFERENCES = new DocumentPreferences
}

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
class DocumentPreferences(alias : String, aliased : Table[DocumentPreferencesRecord], parameters : Array[ Field[_] ]) extends TableImpl[DocumentPreferencesRecord](alias, Public.PUBLIC, aliased, parameters, "") {

	/**
	 * The class holding records for this type
	 */
	override def getRecordType : Class[DocumentPreferencesRecord] = {
		classOf[DocumentPreferencesRecord]
	}

	/**
	 * The column <code>public.document_preferences.id</code>.
	 */
	val ID : TableField[DocumentPreferencesRecord, Integer] = createField("id", org.jooq.impl.SQLDataType.INTEGER.nullable(false).defaulted(true), "")

	/**
	 * The column <code>public.document_preferences.document_id</code>.
	 */
	val DOCUMENT_ID : TableField[DocumentPreferencesRecord, String] = createField("document_id", org.jooq.impl.SQLDataType.CLOB.nullable(false), "")

	/**
	 * The column <code>public.document_preferences.preference_name</code>.
	 */
	val PREFERENCE_NAME : TableField[DocumentPreferencesRecord, String] = createField("preference_name", org.jooq.impl.SQLDataType.CLOB.nullable(false), "")

	/**
	 * The column <code>public.document_preferences.preference_value</code>.
	 */
	val PREFERENCE_VALUE : TableField[DocumentPreferencesRecord, String] = createField("preference_value", org.jooq.impl.SQLDataType.CLOB.nullable(false), "")

	/**
	 * Create a <code>public.document_preferences</code> table reference
	 */
	def this() = {
		this("document_preferences", null, null)
	}

	/**
	 * Create an aliased <code>public.document_preferences</code> table reference
	 */
	def this(alias : String) = {
		this(alias, services.generated.tables.DocumentPreferences.DOCUMENT_PREFERENCES, null)
	}

	private def this(alias : String, aliased : Table[DocumentPreferencesRecord]) = {
		this(alias, aliased, null)
	}

	override def getIdentity : Identity[DocumentPreferencesRecord, Integer] = {
		Keys.IDENTITY_DOCUMENT_PREFERENCES
	}

	override def getPrimaryKey : UniqueKey[DocumentPreferencesRecord] = {
		Keys.DOCUMENT_PREFERENCES_PKEY
	}

	override def getKeys : List[ UniqueKey[DocumentPreferencesRecord] ] = {
		return Arrays.asList[ UniqueKey[DocumentPreferencesRecord] ](Keys.DOCUMENT_PREFERENCES_PKEY)
	}

	override def getReferences : List[ ForeignKey[DocumentPreferencesRecord, _] ] = {
		return Arrays.asList[ ForeignKey[DocumentPreferencesRecord, _] ](Keys.DOCUMENT_PREFERENCES__DOCUMENT_PREFERENCES_DOCUMENT_ID_FKEY)
	}

	override def as(alias : String) : DocumentPreferences = {
		new DocumentPreferences(alias, this)
	}

	/**
	 * Rename this table
	 */
	def rename(name : String) : DocumentPreferences = {
		new DocumentPreferences(name, null)
	}
}
