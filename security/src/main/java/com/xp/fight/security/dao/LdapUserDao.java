package com.xp.fight.security.dao;

import com.xp.fight.security.pojo.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ldap.core.LdapTemplate;
import org.springframework.stereotype.Repository;

import javax.naming.InvalidNameException;
import javax.naming.Name;
import javax.naming.ldap.LdapName;

@Repository
public class LdapUserDao {

    @Autowired
    private LdapTemplate ldapTemplate;

    /***
     * 验证用户名密码是否正确
     * @param userName
     * @param password
     * @return
     */
    public Boolean  isAuthed(String userName,String password){
        LdapName ldapName = StringToLdapName("ou=People");
        return ldapTemplate.authenticate(ldapName,"uid="+userName,password);
    }


    public Person  getPersonByDn(Name username){

        return ldapTemplate.findByDn(username,Person.class);
    }


    public static LdapName StringToLdapName(String dn)
    {
        LdapName ldapName= null;
        try {
            ldapName = new LdapName(dn);
        } catch (InvalidNameException e) {
            e.printStackTrace();
        }
        return ldapName;
    }



}
