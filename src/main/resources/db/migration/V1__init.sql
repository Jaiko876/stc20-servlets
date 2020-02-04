CREATE TABLE mobile.manufacturer (
                                     id integer NOT NULL,
                                     name character varying(40) NOT NULL,
                                     country character varying(40) NOT NULL
);


ALTER TABLE mobile.manufacturer OWNER TO postgres;

--
-- Name: manufacturer_id_seq; Type: SEQUENCE; Schema: mobile; Owner: postgres
--

CREATE SEQUENCE mobile.manufacturer_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE mobile.manufacturer_id_seq OWNER TO postgres;

--
-- Name: manufacturer_id_seq; Type: SEQUENCE OWNED BY; Schema: mobile; Owner: postgres
--

ALTER SEQUENCE mobile.manufacturer_id_seq OWNED BY mobile.manufacturer.id;


--
-- Name: mobile; Type: TABLE; Schema: mobile; Owner: postgres
--

CREATE TABLE mobile.mobile (
                               id integer NOT NULL,
                               model character varying(30) NOT NULL,
                               price integer NOT NULL,
                               manufacturer character varying(40) NOT NULL
);


ALTER TABLE mobile.mobile OWNER TO postgres;

--
-- Name: mobile_id_seq; Type: SEQUENCE; Schema: mobile; Owner: postgres
--

CREATE SEQUENCE mobile.mobile_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE mobile.mobile_id_seq OWNER TO postgres;

--
-- Name: mobile_id_seq; Type: SEQUENCE OWNED BY; Schema: mobile; Owner: postgres
--

ALTER SEQUENCE mobile.mobile_id_seq OWNED BY mobile.mobile.id;


--
-- Name: manufacturer id; Type: DEFAULT; Schema: mobile; Owner: postgres
--

ALTER TABLE ONLY mobile.manufacturer ALTER COLUMN id SET DEFAULT nextval('mobile.manufacturer_id_seq'::regclass);


--
-- Name: mobile id; Type: DEFAULT; Schema: mobile; Owner: postgres
--

ALTER TABLE ONLY mobile.mobile ALTER COLUMN id SET DEFAULT nextval('mobile.mobile_id_seq'::regclass);


--
-- Data for Name: manufacturer; Type: TABLE DATA; Schema: mobile; Owner: postgres
--



--
-- Name: manufacturer_id_seq; Type: SEQUENCE SET; Schema: mobile; Owner: postgres
--

SELECT pg_catalog.setval('mobile.manufacturer_id_seq', 1, false);


--
-- Data for Name: mobile; Type: TABLE DATA; Schema: mobile; Owner: postgres
--



--
-- Name: mobile_id_seq; Type: SEQUENCE SET; Schema: mobile; Owner: postgres
--

SELECT pg_catalog.setval('mobile.mobile_id_seq', 1, false);


--
-- Name: manufacturer manufacturer_pk; Type: CONSTRAINT; Schema: mobile; Owner: postgres
--

ALTER TABLE ONLY mobile.manufacturer
    ADD CONSTRAINT manufacturer_pk PRIMARY KEY (id);


--
-- Name: mobile mobile_pk; Type: CONSTRAINT; Schema: mobile; Owner: postgres
--

ALTER TABLE ONLY mobile.mobile
    ADD CONSTRAINT mobile_pk PRIMARY KEY (id);


--
-- Name: manufacturer_id_uindex; Type: INDEX; Schema: mobile; Owner: postgres
--

CREATE UNIQUE INDEX manufacturer_id_uindex ON mobile.manufacturer USING btree (id);


--
-- Name: manufacturer_name_uindex; Type: INDEX; Schema: mobile; Owner: postgres
--

CREATE UNIQUE INDEX manufacturer_name_uindex ON mobile.manufacturer USING btree (name);


--
-- Name: mobile_id_uindex; Type: INDEX; Schema: mobile; Owner: postgres
--

CREATE UNIQUE INDEX mobile_id_uindex ON mobile.mobile USING btree (id);


--
-- Name: mobile mobile_manufacturer_name_fk; Type: FK CONSTRAINT; Schema: mobile; Owner: postgres
--

ALTER TABLE ONLY mobile.mobile
    ADD CONSTRAINT mobile_manufacturer_name_fk FOREIGN KEY (manufacturer) REFERENCES mobile.manufacturer(name);

create table mobile."user"
(
    id       serial      not null
        constraint user_pk
            primary key,
    login    varchar(50) not null,
    password varchar(200) not null,
    email    varchar(50) not null,
    phone    varchar(50) not null
);

alter table mobile."user"
    owner to postgres;

create unique index user_email_uindex
    on mobile."user" (email);

create unique index user_id_uindex
    on mobile."user" (id);

create unique index user_login_uindex
    on mobile."user" (login);

create unique index user_phone_uindex
    on mobile."user" (phone);
