package com.ljq;

/**
 * @author : LJQ
 * @date : 2019/6/1 11:48
 */
@ReqMapping(meth = ReqMethod.POST,val = "类注解")
public class User {

    @ReqValue(value1 = "战三")
    private String userName;

    @ReqValue(value2 = "123456")
    private String password;

    @ReqMapping(meth = ReqMethod.GET)
    public void   get(){}

    @ReqMapping(meth = ReqMethod.DELETE)
    public void  delete(){}

    @ReqMapping(val = {"1","2"})
    public void other(){}

}
