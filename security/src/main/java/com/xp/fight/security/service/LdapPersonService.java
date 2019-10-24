package com.xp.fight.security.service;


import com.xp.fight.security.dao.LdapUserDao;
import com.xp.fight.security.pojo.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.naming.InvalidNameException;
import javax.naming.Name;
import javax.naming.ldap.LdapName;
import java.util.HashMap;
import java.util.Map;

@Service
public class LdapPersonService {

    @Autowired
    private LdapUserDao ldapUserDao;

    public Map<String,Object> getNameByUser(String username){
        Map<String,Object> map =  new HashMap<>();
        username = "uid="+username+",ou=People";
        Name name = null;
        try {
            name = new LdapName(username);
            Person person = ldapUserDao.getPersonByDn(name);
            if(null!=person){
                /***
                 * 密码进行特殊转换
                 */
                String passwrod = person.getUserPassword();
                String[] temparray=passwrod.split(",");
                byte[] bytestemp=new byte[temparray.length];
                for (int i=0;i<temparray.length;i++)
                {
                    bytestemp[i]=new Byte(temparray[i]);
                }
                String passwordStr=new String(bytestemp);

                map.put("username",String.valueOf(person.getDn()));
                map.put("password",passwordStr);
            }
        } catch (InvalidNameException e) {
            e.printStackTrace();
        }
        return map;
    }

    /****
     *  是否成功验证
     * @param userName
     * @param passwrod
     * @return
     */
    public Boolean  isAuthed(String userName,String passwrod){
        return ldapUserDao.isAuthed(userName,passwrod);
    }


    public static void main(String[] args) {
        //进制转换
        String  pwd = "111111";
        System.out.println(Long.parseLong(pwd,16));

    }
}
