package com.xp.fight.security.pojo;

import org.springframework.ldap.odm.annotations.Attribute;
import org.springframework.ldap.odm.annotations.DnAttribute;
import org.springframework.ldap.odm.annotations.Entry;
import org.springframework.ldap.odm.annotations.Id;
import javax.naming.Name;

/***
 * LDAP 用户类
 */
@Entry(objectClasses = {"inetOrgPerson","organizationalPerson","person","top"},base = "ou=People")
public class Person  {

    @Id
    private Name dn;

    @Attribute(name="cn")
    private String cn;

    @Attribute(name="sn")
    private String sn;

    @Attribute(name="uid")
    @DnAttribute("uid")
    private String uid;

    @Attribute(name="userPassword")
    private String userPassword;
    //部门编号(OA需要和部门的属性一致)
    @Attribute(name="l")
    private String l;
    //邮件地址
    @Attribute(name="mail")
    private String mail;
    //手机号码
    @Attribute(name="mobile")
    private String mobile;
    //部门编号
    @Attribute(name="departmentNumber")
    private String departmentNumber;

    //归属部门
    @Attribute(name="manager")
    private String manager;
    //职务编码
    @Attribute(name="title")
    private String title;
    //座机号码
    @Attribute(name = "telephoneNumber")
    private String telephoneNumber;
    //人员编号
    @Attribute(name = "employeeNumber")
    private String employeeNumber;

    //描述
    @Attribute(name="description")
    private String description;
//    @Attribute(name = "entryUUID")
//    private String entryUUID;

    //    public String getEntryUUID() {
//        return entryUUID;
//    }
//
//    public void setEntryUUID(String entryUUID) {
//        this.entryUUID = entryUUID;
//    }
    public Name getDn() {
        return dn;
    }

    public void setDn(Name dn) {
        this.dn = dn;
    }

    public Person(String uid) {
        this.setUid(uid);
    }
    public Person(){}

    public void setUid(String uid) {
        this.uid = uid;
//        if(getDn()==null){
////            LdapNameBuilder tmpNameBuilder=LdapNameBuilder.newInstance();
////            tmpNameBuilder.add("ou","people")
////                    .add("uid", uid);
//            LdapName ldapName= PersonConvert.StringToLdapName(PERSON_ID+"="+uid+","+PERSON_BASE_DN);
//            this.setDn(ldapName);
//        }
    }

    public String getUid() {
        return uid;
    }

    public String getManager() {
        return manager;
    }

    public void setManager(String manager) {
        this.manager = manager;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public String getDescription() {
        return description;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setDescription (String description) {
        this.description = description;
    }

    public String getCn() {
        return cn;
    }

    public void setCn(String cn) {
        this.cn = cn;
    }

    public String getSn() {
        return sn;
    }

    public void setSn(String sn) {
        this.sn = sn;
    }

    public String getTelephoneNumber() {
        return telephoneNumber;
    }

    public void setTelephoneNumber(String telephoneNumber) {
        this.telephoneNumber = telephoneNumber;
    }

    public String getL() {
        return l;
    }

    public void setL(String l) {
        this.l = l;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getDepartmentNumber() {
        return departmentNumber;
    }

    public void setDepartmentNumber(String departmentNumber) {
        this.departmentNumber = departmentNumber;
    }

    public String getEmployeeNumber() {
        return employeeNumber;
    }

    public void setEmployeeNumber(String employeeNumber) {
        this.employeeNumber = employeeNumber;
    }
}