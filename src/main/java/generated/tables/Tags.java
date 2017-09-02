/**
 * This class is generated by jOOQ
 */
package generated.tables;


import generated.Keys;
import generated.Public;
import generated.tables.records.TagsRecord;

import java.util.Arrays;
import java.util.List;

import javax.annotation.Generated;

import org.jooq.Field;
import org.jooq.ForeignKey;
import org.jooq.Identity;
import org.jooq.Table;
import org.jooq.TableField;
import org.jooq.UniqueKey;
import org.jooq.impl.TableImpl;


/**
 * This class is generated by jOOQ.
 */
@Generated(
	value = {
		"http://www.jooq.org",
		"jOOQ version:3.7.4"
	},
	comments = "This class is generated by jOOQ"
)
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class Tags extends TableImpl<TagsRecord> {

	private static final long serialVersionUID = 1686802147;

	/**
	 * The reference instance of <code>public.tags</code>
	 */
	public static final Tags TAGS = new Tags();

	/**
	 * The class holding records for this type
	 */
	@Override
	public Class<TagsRecord> getRecordType() {
		return TagsRecord.class;
	}

	/**
	 * The column <code>public.tags.id</code>.
	 */
	public final TableField<TagsRecord, Integer> ID = createField("id", org.jooq.impl.SQLDataType.INTEGER.nullable(false).defaulted(true), this, "");

	/**
	 * The column <code>public.tags.tag</code>.
	 */
	public final TableField<TagsRecord, String> TAG = createField("tag", org.jooq.impl.SQLDataType.VARCHAR.length(255), this, "");

	/**
	 * The column <code>public.tags.recieptid</code>.
	 */
	public final TableField<TagsRecord, Integer> RECIEPTID = createField("recieptid", org.jooq.impl.SQLDataType.INTEGER, this, "");

	/**
	 * Create a <code>public.tags</code> table reference
	 */
	public Tags() {
		this("tags", null);
	}

	/**
	 * Create an aliased <code>public.tags</code> table reference
	 */
	public Tags(String alias) {
		this(alias, TAGS);
	}

	private Tags(String alias, Table<TagsRecord> aliased) {
		this(alias, aliased, null);
	}

	private Tags(String alias, Table<TagsRecord> aliased, Field<?>[] parameters) {
		super(alias, Public.PUBLIC, aliased, parameters, "");
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Identity<TagsRecord, Integer> getIdentity() {
		return Keys.IDENTITY_TAGS;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public UniqueKey<TagsRecord> getPrimaryKey() {
		return Keys.CONSTRAINT_27;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public List<UniqueKey<TagsRecord>> getKeys() {
		return Arrays.<UniqueKey<TagsRecord>>asList(Keys.CONSTRAINT_27);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public List<ForeignKey<TagsRecord, ?>> getReferences() {
		return Arrays.<ForeignKey<TagsRecord, ?>>asList(Keys.CONSTRAINT_2);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Tags as(String alias) {
		return new Tags(alias, this);
	}

	/**
	 * Rename this table
	 */
	public Tags rename(String name) {
		return new Tags(name, null);
	}
}
