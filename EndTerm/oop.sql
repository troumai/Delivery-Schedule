PGDMP                 	        x            oop    10.14    10.14                0    0    ENCODING    ENCODING        SET client_encoding = 'UTF8';
                       false                       0    0 
   STDSTRINGS 
   STDSTRINGS     (   SET standard_conforming_strings = 'on';
                       false                       0    0 
   SEARCHPATH 
   SEARCHPATH     8   SELECT pg_catalog.set_config('search_path', '', false);
                       false                       1262    49152    oop    DATABASE     ?   CREATE DATABASE oop WITH TEMPLATE = template0 ENCODING = 'UTF8' LC_COLLATE = 'Russian_Kazakhstan.1251' LC_CTYPE = 'Russian_Kazakhstan.1251';
    DROP DATABASE oop;
             postgres    false                        2615    2200    public    SCHEMA        CREATE SCHEMA public;
    DROP SCHEMA public;
             postgres    false                       0    0    SCHEMA public    COMMENT     6   COMMENT ON SCHEMA public IS 'standard public schema';
                  postgres    false    3                        3079    12924    plpgsql 	   EXTENSION     ?   CREATE EXTENSION IF NOT EXISTS plpgsql WITH SCHEMA pg_catalog;
    DROP EXTENSION plpgsql;
                  false            	           0    0    EXTENSION plpgsql    COMMENT     @   COMMENT ON EXTENSION plpgsql IS 'PL/pgSQL procedural language';
                       false    1            ?            1259    57366 	   car_owner    TABLE     +  CREATE TABLE public.car_owner (
    id integer NOT NULL,
    fname character varying(50),
    lname character varying(50),
    car_brand character varying(50),
    car_color character varying(50),
    car_number character varying(50),
    reg_num character varying(10),
    year_of_issue integer
);
    DROP TABLE public.car_owner;
       public         postgres    false    3            ?            1259    57364    car_owner_id_seq    SEQUENCE     ?   CREATE SEQUENCE public.car_owner_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 '   DROP SEQUENCE public.car_owner_id_seq;
       public       postgres    false    3    197            
           0    0    car_owner_id_seq    SEQUENCE OWNED BY     E   ALTER SEQUENCE public.car_owner_id_seq OWNED BY public.car_owner.id;
            public       postgres    false    196            ?            1259    73730    delivery_sch    TABLE     ?   CREATE TABLE public.delivery_sch (
    id integer NOT NULL,
    del_date date,
    company_name character varying(50),
    director_name character varying(100),
    del_time time without time zone,
    weight integer
);
     DROP TABLE public.delivery_sch;
       public         postgres    false    3            ?            1259    73728    delivery_sch_id_seq    SEQUENCE     ?   CREATE SEQUENCE public.delivery_sch_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 *   DROP SEQUENCE public.delivery_sch_id_seq;
       public       postgres    false    201    3                       0    0    delivery_sch_id_seq    SEQUENCE OWNED BY     K   ALTER SEQUENCE public.delivery_sch_id_seq OWNED BY public.delivery_sch.id;
            public       postgres    false    200            ?            1259    57380    students    TABLE     ?   CREATE TABLE public.students (
    id integer NOT NULL,
    name character varying(50),
    surname character varying(50),
    age bigint
);
    DROP TABLE public.students;
       public         postgres    false    3            ?            1259    57378    students_id_seq    SEQUENCE     ?   CREATE SEQUENCE public.students_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 &   DROP SEQUENCE public.students_id_seq;
       public       postgres    false    199    3                       0    0    students_id_seq    SEQUENCE OWNED BY     C   ALTER SEQUENCE public.students_id_seq OWNED BY public.students.id;
            public       postgres    false    198            z
           2604    57369    car_owner id    DEFAULT     l   ALTER TABLE ONLY public.car_owner ALTER COLUMN id SET DEFAULT nextval('public.car_owner_id_seq'::regclass);
 ;   ALTER TABLE public.car_owner ALTER COLUMN id DROP DEFAULT;
       public       postgres    false    197    196    197            |
           2604    73733    delivery_sch id    DEFAULT     r   ALTER TABLE ONLY public.delivery_sch ALTER COLUMN id SET DEFAULT nextval('public.delivery_sch_id_seq'::regclass);
 >   ALTER TABLE public.delivery_sch ALTER COLUMN id DROP DEFAULT;
       public       postgres    false    201    200    201            {
           2604    57383    students id    DEFAULT     j   ALTER TABLE ONLY public.students ALTER COLUMN id SET DEFAULT nextval('public.students_id_seq'::regclass);
 :   ALTER TABLE public.students ALTER COLUMN id DROP DEFAULT;
       public       postgres    false    198    199    199            ?
          0    57366 	   car_owner 
   TABLE DATA               o   COPY public.car_owner (id, fname, lname, car_brand, car_color, car_number, reg_num, year_of_issue) FROM stdin;
    public       postgres    false    197   [                 0    73730    delivery_sch 
   TABLE DATA               c   COPY public.delivery_sch (id, del_date, company_name, director_name, del_time, weight) FROM stdin;
    public       postgres    false    201   ?       ?
          0    57380    students 
   TABLE DATA               :   COPY public.students (id, name, surname, age) FROM stdin;
    public       postgres    false    199   R                   0    0    car_owner_id_seq    SEQUENCE SET     ?   SELECT pg_catalog.setval('public.car_owner_id_seq', 44, true);
            public       postgres    false    196                       0    0    delivery_sch_id_seq    SEQUENCE SET     A   SELECT pg_catalog.setval('public.delivery_sch_id_seq', 7, true);
            public       postgres    false    200                       0    0    students_id_seq    SEQUENCE SET     =   SELECT pg_catalog.setval('public.students_id_seq', 8, true);
            public       postgres    false    198            ~
           2606    57377    car_owner car_owner_pkey 
   CONSTRAINT     V   ALTER TABLE ONLY public.car_owner
    ADD CONSTRAINT car_owner_pkey PRIMARY KEY (id);
 B   ALTER TABLE ONLY public.car_owner DROP CONSTRAINT car_owner_pkey;
       public         postgres    false    197            ?
           2606    73735    delivery_sch delivery_sch_pkey 
   CONSTRAINT     \   ALTER TABLE ONLY public.delivery_sch
    ADD CONSTRAINT delivery_sch_pkey PRIMARY KEY (id);
 H   ALTER TABLE ONLY public.delivery_sch DROP CONSTRAINT delivery_sch_pkey;
       public         postgres    false    201            ?
           2606    57385    students students_pkey 
   CONSTRAINT     T   ALTER TABLE ONLY public.students
    ADD CONSTRAINT students_pkey PRIMARY KEY (id);
 @   ALTER TABLE ONLY public.students DROP CONSTRAINT students_pkey;
       public         postgres    false    199            ?
   N  x?uTMo?0<???????G>?1?n%DW???^z1?"??섊?/??¡?Й?y3????l?e?????ή??]?F?"?????X?E$??Ѿ?wv?????,`ՆF[(?6?E??M?ak?	>??	?P??}P??:ygTs笇g?QX?P!?[nj?ѴCs\?0+???P??K????
?8??V[??wT?U9ĕ?)a6?P8?TO?G??ҹ#.ZxYv3*t?#+?Y1a	|jt??浑???}?????????露k?h?5el??M(?!f???
A?$,e}?v~='^??z?]?ZJ??[CS???2Nau6????XK;?`?t?????2?w9m?{`?+??q?棩??b???.Ý1چ????h(	?`-k?&y^?KBܲ[??+?z?6?7P$???b?o???yi?p:?Sl?Nx??????Q?????JZ???????Gtp^????)}?I??kć\G4????S?DL4ލH?w??q???9?]?8Y?ߥ?*4=tz??x]?q
?,z2?7{uҐ?G?Y?蝎I??VϘ̢?[_??0?B??i?-?ﾲ?II? '_?!? {{?         ?   x?M?M
?0???S?????4;-?)*????P???E???ˠIS?:Ղe5wX??5)?{BgF?!Ry/???*???&پ%???"%???.???I??;0??HG??]mv?gz$uZP?M?Q?J?c&?      ?
   m   x?3????,?,?tL?????2?tI?K??-?? q?9?2??9}S??A\NǼ?????"ה?171?32???5?́pA<sd?s?sR+S?A2h2???\1z\\\ Ig(?     