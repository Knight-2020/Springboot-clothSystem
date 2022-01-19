    insert into role(name, description) values('user', '用户');
    insert into menu(id, parent_id, name, icon, href, role) values(1, 0, '个人信息', '', '/personInfoPage', 'user');
    insert into menu(id, parent_id, name, icon, href, role) values(2, 0, '衣服管理', '', '/cloth/tablePage', 'user');
    insert into menu(id, parent_id, name, icon, href, role) values(3, 0, '分类管理', '', '/type/tablePage', 'user');
    insert into menu(id, parent_id, name, icon, href, role) values(4, 0, '套装管理', '', '/suit/tablePage', 'user');

    insert into permission(operation, role, model) values('add', 'user', 'type');
    insert into permission(operation, role, model) values('edit', 'user', 'type');
    insert into permission(operation, role, model) values('detail', 'user', 'type');
    insert into permission(operation, role, model) values('delete', 'user', 'type');
    insert into permission(operation, role, model) values('add', 'user', 'cloth');
    insert into permission(operation, role, model) values('edit', 'user', 'cloth');
    insert into permission(operation, role, model) values('detail', 'user', 'cloth');
    insert into permission(operation, role, model) values('delete', 'user', 'cloth');
    insert into permission(operation, role, model) values('add', 'user', 'suit');
    insert into permission(operation, role, model) values('edit', 'user', 'suit');
    insert into permission(operation, role, model) values('detail', 'user', 'suit');
    insert into permission(operation, role, model) values('delete', 'user', 'suit');

    insert into user(username, password, role) values('user', 'user', 'user');
