
INSERT INTO public.menu (id_menu, icon, name, url) VALUES (2, 'business_center', 'Department', '/department');
INSERT INTO public.menu (id_menu, icon, name, url) VALUES (3, 'person', 'Employee', '/employee');
INSERT INTO public.menu (id_menu, icon, name, url) VALUES (1, 'account_balance', 'Enterprise', '/enterprise');

INSERT INTO public.rol (id_rol, description, name) VALUES (1, 'admin', 'admin');
INSERT INTO public.rol (id_rol, description, name) VALUES (2, 'vendor', 'vendor');

INSERT INTO public.users (id_user, enabled, password, username) VALUES (1, true, '123', 'admin');
INSERT INTO public.users (id_user, enabled, password, username) VALUES (2, true, '123', 'user1');

INSERT INTO public.menu_rol (id_menu, id_rol) VALUES (1, 1);
INSERT INTO public.menu_rol (id_menu, id_rol) VALUES (2, 1);
INSERT INTO public.menu_rol (id_menu, id_rol) VALUES (3, 1);
INSERT INTO public.menu_rol (id_menu, id_rol) VALUES (3, 2);

INSERT INTO public.user_rol (id_user, id_rol) VALUES (1, 1);
INSERT INTO public.user_rol (id_user, id_rol) VALUES (2, 2);





