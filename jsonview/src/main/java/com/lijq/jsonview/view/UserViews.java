package com.lijq.jsonview.view;

/**
 * @author : lijq
 * @date : 2020/3/19 13:15
 */
public interface UserViews {

    interface UserView {
    }

    interface UserSimpleView extends UserView {
    }

    interface UserDetailView extends UserView, UserSimpleView {
    }

    interface UserDeptView extends UserView, UserSimpleView, DeptViews.DeptView {
    }

    interface UserRoleView extends UserView, RoleViews.RoleView {
    }

    interface UserDeptRoleView extends UserView, UserDeptView, UserRoleView {
    }
}
