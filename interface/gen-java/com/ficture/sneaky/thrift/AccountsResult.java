/**
 * Autogenerated by Thrift
 *
 * DO NOT EDIT UNLESS YOU ARE SURE THAT YOU KNOW WHAT YOU ARE DOING
 */
package com.ficture.sneaky.thrift;

import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;
import java.util.EnumMap;
import java.util.Set;
import java.util.HashSet;
import java.util.EnumSet;
import java.util.Collections;
import java.util.BitSet;
import java.nio.ByteBuffer;
import java.util.Arrays;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class AccountsResult implements org.apache.thrift.TBase<AccountsResult, AccountsResult._Fields>, java.io.Serializable, Cloneable {
  private static final org.apache.thrift.protocol.TStruct STRUCT_DESC = new org.apache.thrift.protocol.TStruct("AccountsResult");

  private static final org.apache.thrift.protocol.TField ACCOUNTS_FIELD_DESC = new org.apache.thrift.protocol.TField("accounts", org.apache.thrift.protocol.TType.LIST, (short)1);
  private static final org.apache.thrift.protocol.TField CURSOR_FIELD_DESC = new org.apache.thrift.protocol.TField("cursor", org.apache.thrift.protocol.TType.STRING, (short)2);

  public List<Account> accounts;
  public String cursor;

  /** The set of fields this struct contains, along with convenience methods for finding and manipulating them. */
  public enum _Fields implements org.apache.thrift.TFieldIdEnum {
    ACCOUNTS((short)1, "accounts"),
    CURSOR((short)2, "cursor");

    private static final Map<String, _Fields> byName = new HashMap<String, _Fields>();

    static {
      for (_Fields field : EnumSet.allOf(_Fields.class)) {
        byName.put(field.getFieldName(), field);
      }
    }

    /**
     * Find the _Fields constant that matches fieldId, or null if its not found.
     */
    public static _Fields findByThriftId(int fieldId) {
      switch(fieldId) {
        case 1: // ACCOUNTS
          return ACCOUNTS;
        case 2: // CURSOR
          return CURSOR;
        default:
          return null;
      }
    }

    /**
     * Find the _Fields constant that matches fieldId, throwing an exception
     * if it is not found.
     */
    public static _Fields findByThriftIdOrThrow(int fieldId) {
      _Fields fields = findByThriftId(fieldId);
      if (fields == null) throw new IllegalArgumentException("Field " + fieldId + " doesn't exist!");
      return fields;
    }

    /**
     * Find the _Fields constant that matches name, or null if its not found.
     */
    public static _Fields findByName(String name) {
      return byName.get(name);
    }

    private final short _thriftId;
    private final String _fieldName;

    _Fields(short thriftId, String fieldName) {
      _thriftId = thriftId;
      _fieldName = fieldName;
    }

    public short getThriftFieldId() {
      return _thriftId;
    }

    public String getFieldName() {
      return _fieldName;
    }
  }

  // isset id assignments

  public static final Map<_Fields, org.apache.thrift.meta_data.FieldMetaData> metaDataMap;
  static {
    Map<_Fields, org.apache.thrift.meta_data.FieldMetaData> tmpMap = new EnumMap<_Fields, org.apache.thrift.meta_data.FieldMetaData>(_Fields.class);
    tmpMap.put(_Fields.ACCOUNTS, new org.apache.thrift.meta_data.FieldMetaData("accounts", org.apache.thrift.TFieldRequirementType.REQUIRED, 
        new org.apache.thrift.meta_data.ListMetaData(org.apache.thrift.protocol.TType.LIST, 
            new org.apache.thrift.meta_data.StructMetaData(org.apache.thrift.protocol.TType.STRUCT, Account.class))));
    tmpMap.put(_Fields.CURSOR, new org.apache.thrift.meta_data.FieldMetaData("cursor", org.apache.thrift.TFieldRequirementType.OPTIONAL, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.STRING)));
    metaDataMap = Collections.unmodifiableMap(tmpMap);
    org.apache.thrift.meta_data.FieldMetaData.addStructMetaDataMap(AccountsResult.class, metaDataMap);
  }

  public AccountsResult() {
  }

  public AccountsResult(
    List<Account> accounts)
  {
    this();
    this.accounts = accounts;
  }

  /**
   * Performs a deep copy on <i>other</i>.
   */
  public AccountsResult(AccountsResult other) {
    if (other.isSetAccounts()) {
      List<Account> __this__accounts = new ArrayList<Account>();
      for (Account other_element : other.accounts) {
        __this__accounts.add(new Account(other_element));
      }
      this.accounts = __this__accounts;
    }
    if (other.isSetCursor()) {
      this.cursor = other.cursor;
    }
  }

  public AccountsResult deepCopy() {
    return new AccountsResult(this);
  }

  @Override
  public void clear() {
    this.accounts = null;
    this.cursor = null;
  }

  public int getAccountsSize() {
    return (this.accounts == null) ? 0 : this.accounts.size();
  }

  public java.util.Iterator<Account> getAccountsIterator() {
    return (this.accounts == null) ? null : this.accounts.iterator();
  }

  public void addToAccounts(Account elem) {
    if (this.accounts == null) {
      this.accounts = new ArrayList<Account>();
    }
    this.accounts.add(elem);
  }

  public List<Account> getAccounts() {
    return this.accounts;
  }

  public AccountsResult setAccounts(List<Account> accounts) {
    this.accounts = accounts;
    return this;
  }

  public void unsetAccounts() {
    this.accounts = null;
  }

  /** Returns true if field accounts is set (has been assigned a value) and false otherwise */
  public boolean isSetAccounts() {
    return this.accounts != null;
  }

  public void setAccountsIsSet(boolean value) {
    if (!value) {
      this.accounts = null;
    }
  }

  public String getCursor() {
    return this.cursor;
  }

  public AccountsResult setCursor(String cursor) {
    this.cursor = cursor;
    return this;
  }

  public void unsetCursor() {
    this.cursor = null;
  }

  /** Returns true if field cursor is set (has been assigned a value) and false otherwise */
  public boolean isSetCursor() {
    return this.cursor != null;
  }

  public void setCursorIsSet(boolean value) {
    if (!value) {
      this.cursor = null;
    }
  }

  public void setFieldValue(_Fields field, Object value) {
    switch (field) {
    case ACCOUNTS:
      if (value == null) {
        unsetAccounts();
      } else {
        setAccounts((List<Account>)value);
      }
      break;

    case CURSOR:
      if (value == null) {
        unsetCursor();
      } else {
        setCursor((String)value);
      }
      break;

    }
  }

  public Object getFieldValue(_Fields field) {
    switch (field) {
    case ACCOUNTS:
      return getAccounts();

    case CURSOR:
      return getCursor();

    }
    throw new IllegalStateException();
  }

  /** Returns true if field corresponding to fieldID is set (has been assigned a value) and false otherwise */
  public boolean isSet(_Fields field) {
    if (field == null) {
      throw new IllegalArgumentException();
    }

    switch (field) {
    case ACCOUNTS:
      return isSetAccounts();
    case CURSOR:
      return isSetCursor();
    }
    throw new IllegalStateException();
  }

  @Override
  public boolean equals(Object that) {
    if (that == null)
      return false;
    if (that instanceof AccountsResult)
      return this.equals((AccountsResult)that);
    return false;
  }

  public boolean equals(AccountsResult that) {
    if (that == null)
      return false;

    boolean this_present_accounts = true && this.isSetAccounts();
    boolean that_present_accounts = true && that.isSetAccounts();
    if (this_present_accounts || that_present_accounts) {
      if (!(this_present_accounts && that_present_accounts))
        return false;
      if (!this.accounts.equals(that.accounts))
        return false;
    }

    boolean this_present_cursor = true && this.isSetCursor();
    boolean that_present_cursor = true && that.isSetCursor();
    if (this_present_cursor || that_present_cursor) {
      if (!(this_present_cursor && that_present_cursor))
        return false;
      if (!this.cursor.equals(that.cursor))
        return false;
    }

    return true;
  }

  @Override
  public int hashCode() {
    return 0;
  }

  public int compareTo(AccountsResult other) {
    if (!getClass().equals(other.getClass())) {
      return getClass().getName().compareTo(other.getClass().getName());
    }

    int lastComparison = 0;
    AccountsResult typedOther = (AccountsResult)other;

    lastComparison = Boolean.valueOf(isSetAccounts()).compareTo(typedOther.isSetAccounts());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetAccounts()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.accounts, typedOther.accounts);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = Boolean.valueOf(isSetCursor()).compareTo(typedOther.isSetCursor());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetCursor()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.cursor, typedOther.cursor);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    return 0;
  }

  public _Fields fieldForId(int fieldId) {
    return _Fields.findByThriftId(fieldId);
  }

  public void read(org.apache.thrift.protocol.TProtocol iprot) throws org.apache.thrift.TException {
    org.apache.thrift.protocol.TField field;
    iprot.readStructBegin();
    while (true)
    {
      field = iprot.readFieldBegin();
      if (field.type == org.apache.thrift.protocol.TType.STOP) { 
        break;
      }
      switch (field.id) {
        case 1: // ACCOUNTS
          if (field.type == org.apache.thrift.protocol.TType.LIST) {
            {
              org.apache.thrift.protocol.TList _list10 = iprot.readListBegin();
              this.accounts = new ArrayList<Account>(_list10.size);
              for (int _i11 = 0; _i11 < _list10.size; ++_i11)
              {
                Account _elem12;
                _elem12 = new Account();
                _elem12.read(iprot);
                this.accounts.add(_elem12);
              }
              iprot.readListEnd();
            }
          } else { 
            org.apache.thrift.protocol.TProtocolUtil.skip(iprot, field.type);
          }
          break;
        case 2: // CURSOR
          if (field.type == org.apache.thrift.protocol.TType.STRING) {
            this.cursor = iprot.readString();
          } else { 
            org.apache.thrift.protocol.TProtocolUtil.skip(iprot, field.type);
          }
          break;
        default:
          org.apache.thrift.protocol.TProtocolUtil.skip(iprot, field.type);
      }
      iprot.readFieldEnd();
    }
    iprot.readStructEnd();

    // check for required fields of primitive type, which can't be checked in the validate method
    validate();
  }

  public void write(org.apache.thrift.protocol.TProtocol oprot) throws org.apache.thrift.TException {
    validate();

    oprot.writeStructBegin(STRUCT_DESC);
    if (this.accounts != null) {
      oprot.writeFieldBegin(ACCOUNTS_FIELD_DESC);
      {
        oprot.writeListBegin(new org.apache.thrift.protocol.TList(org.apache.thrift.protocol.TType.STRUCT, this.accounts.size()));
        for (Account _iter13 : this.accounts)
        {
          _iter13.write(oprot);
        }
        oprot.writeListEnd();
      }
      oprot.writeFieldEnd();
    }
    if (this.cursor != null) {
      if (isSetCursor()) {
        oprot.writeFieldBegin(CURSOR_FIELD_DESC);
        oprot.writeString(this.cursor);
        oprot.writeFieldEnd();
      }
    }
    oprot.writeFieldStop();
    oprot.writeStructEnd();
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder("AccountsResult(");
    boolean first = true;

    sb.append("accounts:");
    if (this.accounts == null) {
      sb.append("null");
    } else {
      sb.append(this.accounts);
    }
    first = false;
    if (isSetCursor()) {
      if (!first) sb.append(", ");
      sb.append("cursor:");
      if (this.cursor == null) {
        sb.append("null");
      } else {
        sb.append(this.cursor);
      }
      first = false;
    }
    sb.append(")");
    return sb.toString();
  }

  public void validate() throws org.apache.thrift.TException {
    // check for required fields
    if (accounts == null) {
      throw new org.apache.thrift.protocol.TProtocolException("Required field 'accounts' was not present! Struct: " + toString());
    }
  }

  private void writeObject(java.io.ObjectOutputStream out) throws java.io.IOException {
    try {
      write(new org.apache.thrift.protocol.TCompactProtocol(new org.apache.thrift.transport.TIOStreamTransport(out)));
    } catch (org.apache.thrift.TException te) {
      throw new java.io.IOException(te);
    }
  }

  private void readObject(java.io.ObjectInputStream in) throws java.io.IOException, ClassNotFoundException {
    try {
      read(new org.apache.thrift.protocol.TCompactProtocol(new org.apache.thrift.transport.TIOStreamTransport(in)));
    } catch (org.apache.thrift.TException te) {
      throw new java.io.IOException(te);
    }
  }

}

