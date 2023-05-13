--
-- PostgreSQL database dump
--

-- Dumped from database version 14.1
-- Dumped by pg_dump version 14.1

SET statement_timeout = 0;
SET lock_timeout = 0;
SET idle_in_transaction_session_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SELECT pg_catalog.set_config('search_path', '', false);
SET check_function_bodies = false;
SET xmloption = content;
SET client_min_messages = warning;
SET row_security = off;

--
-- Name: chargingpile; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.chargingpile
    START WITH 0
    INCREMENT BY 1
    MINVALUE 0
    MAXVALUE 9000000000
    CACHE 1;


ALTER TABLE public.chargingpile OWNER TO postgres;

SET default_tablespace = '';

SET default_table_access_method = heap;

--
-- Name: charging_pile; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.charging_pile (
    cp_id integer DEFAULT nextval('public.chargingpile'::regclass) NOT NULL,
    locality character varying NOT NULL,
    state character varying
);


ALTER TABLE public.charging_pile OWNER TO postgres;

--
-- Data for Name: charging_pile; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.charging_pile (cp_id, locality, state) FROM stdin;
1	113.367184 23.159042;113.367181 23.158919;113.368188 23.158925;113.368188 23.15904	可用
2	113.366929 23.159179;113.366926 23.159074; 113.368154 23.159069;113.368149 23.159168	可用
4	113.36911 23.162389;113.369108 23.162299;113.369851 23.162295;113.369849 23.162382	可用
5	113.36911 23.162273;113.369112 23.162159;113.369851 23.162159;113.369851 23.162262	可用
6	113.369935 23.162385;113.370702 23.162377;113.370704 23.162292;113.369935 23.162301\n	可用
7	113.369926 23.162261;113.369926 23.162156;113.370702 23.162154;113.370699 23.162257	可用
8	113.370756 23.162391;113.370756 23.162302;113.371621 23.162297;113.371618 23.162388\n	可用
9	113.370753 23.162262;113.370753 23.162163;113.371615 23.162155;113.371618 23.162257	可用
10	113.37076 23.161691;113.370751 23.161588;113.3716 23.161593;113.371607 23.161691	可用
11	113.371723 23.160451;113.372377 23.160451;113.372377 23.160279;113.371731 23.16029\n	可用
12	113.367184 23.159042;113.367181 23.158919;113.368188 23.158925;113.368188 23.15904	可用
13	113.366929 23.159179;113.366926 23.159074;113.368154 23.159069;113.368149 23.159168	可用
14	113.36911 23.162389;113.369108 23.162299;113.369851 23.162295;113.369849 23.162382	可用
15	113.36911 23.162273;113.369112 23.162159;113.369851 23.162159;113.369851 23.162262	可用
16	113.369935 23.162385;113.370702 23.162377;113.370704 23.162292;113.369935 23.162301	可用
17	113.369926 23.162261;113.369926 23.162156;113.370702 23.162154;113.370699 23.162257	可用
18	113.370756 23.162391;113.370756 23.162302;113.371621 23.162297;113.371618 23.162388	可用
19	113.370753 23.162262;113.370753 23.162163;113.371615 23.162155;113.371618 23.162257	可用
20	113.37076 23.161691;113.370751 23.161588;113.3716 23.161593;113.371607 23.161691	可用
21	113.371723 23.160451;113.372377 23.160451;113.372377 23.160279;113.371731 23.16029	可用
22	113.371926 23.154157;113.369658 23.153183;113.369691 23.153137;113.371956 23.154081	可用
23	113.368873 23.152691;113.36968 23.152681;113.369669 23.152551;113.368877 23.152564	可用
24	113.368881 23.152161;113.369665 23.152164;113.369661 23.152062;113.368877 23.152062	可用
25	113.366604 23.152754;113.3666 23.152657;113.367038 23.152663;113.367036 23.152746	可用
26	113.366586 23.15243;113.366582 23.152322;113.367015 23.152316;113.367027 23.152424	可用
27	113.366568 23.15209;113.366566 23.151982;113.367031 23.151971;113.367038 23.152087	可用
28	113.367174 23.152771;113.367172 23.152654;113.367681 23.152654;113.367687 23.152768	可用
29	113.367176 23.152424;113.36718 23.152314;113.367692 23.152317;113.367692 23.152419	可用
30	113.367182 23.152095;113.367185 23.151972;113.367675 23.151969;113.367685 23.152092	可用
31	113.368395 23.152755;113.368399 23.152654;113.368765 23.152648;113.368773 23.152737	可用
32	113.368416 23.152437;113.368421 23.152307;113.36871 23.152314;113.368718 23.152437	可用
33	113.368413 23.152092;113.368413 23.151984;113.368705 23.151986;113.368721 23.152083	可用
34	113.366996 23.160075;113.366994 23.159837;113.367077 23.159841;113.367077 23.160075	可用
35	113.367571 23.160083;113.367569 23.159841;113.367641 23.159841;113.367648 23.160081	可用
36	113.356412 23.162844;113.356412 23.162782;113.357022 23.162786;113.357024 23.16285	可用
37	113.357351 23.162856;113.357354 23.162788;113.357914 23.162778;113.357921 23.16285	可用
38	113.357331 23.162731;113.357331 23.162644;113.357867 23.162636;113.357871 23.162737	可用
39	113.358239 23.162852;113.358237 23.162792;113.358689 23.16278;113.35868 23.162848	可用
40	113.35823 23.162733;113.358234 23.162632;113.358683 23.162634;113.358683 23.162729	可用
41	113.358788 23.162739;113.358788 23.162648;113.359246 23.16265;113.359244 23.162739;113.359116 23.162738	可用
42	113.3595 23.162743;113.3595 23.162646;113.359964 23.162646;113.359964 23.16274	可用
43	113.36012 23.162664;113.360122 23.16259;113.360569 23.162592;113.360565 23.162659	可用
44	113.358263 23.162071;113.360383 23.162065;113.360383 23.161949;113.358259 23.161956	可用
45	113.359657 23.158733;113.359657 23.158654;113.360661 23.158666;113.360655 23.158741	可用
46	113.361423 23.159607;113.362056 23.159441;113.362028 23.159375;113.361404 23.159551	可用
47	113.35429 23.162381;113.354895 23.162376;113.354887 23.162238;113.354274 23.162251	可用
48	113.351084 23.161468;113.351083 23.16142;113.351692 23.161428;113.351686 23.161461	可用
49	113.350479 23.161607;113.350482 23.161566;113.35099 23.161574;113.350999 23.161614	可用
50	113.349452 23.161316;113.349457 23.161287;113.349875 23.16136;113.349866 23.161389	可用
51	113.348748 23.161399;113.348762 23.161329;113.349008 23.161377;113.348989 23.161449	可用
52	113.348221 23.162545;113.348254 23.162444;113.348779 23.162563;113.348757 23.162648	可用
53	113.348562 23.163468;113.348784 23.163478;113.348778 23.163514;113.348558 23.163496	可用
54	113.348449 23.160201;113.348948 23.160197;113.348943 23.160124;113.34846 23.160152	可用
55	113.348401 23.159849;113.348405 23.159778;113.349217 23.159769;113.349215 23.15986	可用
56	113.347792 23.160088;113.347635 23.160161;113.347412 23.16021;113.347358 23.160215;113.347332 23.160241;113.347205 23.160226;113.347205 23.160193;113.347353 23.160193;113.347695 23.160098;113.347759 23.160055	可用
57	113.346913 23.160202;113.346801 23.160205;113.346486 23.160132;113.346318 23.160064;113.346348 23.160023;113.346563 23.160123;113.346905 23.160181	可用
58	113.346112 23.159933;113.345866 23.159802;113.345721 23.159681;113.345625 23.159583;113.345638 23.159577;113.345884 23.159794;113.346121 23.159915	可用
59	113.345522 23.159297;113.345525 23.159264;113.345617 23.159264;113.345856 23.159298;113.346037 23.159381;113.346026 23.159414;113.345918 23.159368;113.345829 23.159335;113.345667 23.159309	可用
60	113.346086 23.159478;113.346675 23.159735;113.346699 23.159689;113.346565 23.159649;113.346118 23.159439;113.3461 23.159456	可用
61	113.346811 23.15976;113.347405 23.159801;113.347401 23.159748;113.346816 23.159719	可用
62	113.347528 23.159768;113.347725 23.159737;113.347924 23.159739;113.348136 23.159799;113.348165 23.159745;113.347929 23.159699;113.347731 23.159704;113.347519 23.159733	可用
63	113.345235 23.158478;113.34564 23.158492;113.34564 23.158363;113.345233 23.158358	可用
64	113.344545 23.158406;113.344545 23.158303;113.345028 23.158294;113.345036 23.158399	可用
65	113.344521 23.157514;113.344514 23.157397;113.345037 23.157388;113.345034 23.157511	可用
66	113.344885 23.157894;113.344887 23.15773;113.345098 23.157733;113.345103 23.157901;113.345101 23.157901;113.345081 23.157902	可用
67	113.350099 23.159084;113.350096 23.159026;113.350913 23.159036;113.350913 23.159061	可用
68	113.347783 23.158505;113.348096 23.158525;113.348104 23.158461;113.347788 23.158439	可用
69	113.351729 23.157013;113.351735 23.156937;113.352588 23.15694;113.352621 23.157464;113.352569 23.157464;113.352547 23.156994	可用
70	113.355714 23.153367;113.356207 23.153361;113.356215 23.15329;113.355954 23.153325;113.355719 23.153326	可用
71	113.355736 23.153246;113.355739 23.153202;113.35621 23.153203;113.3562 23.153255	可用
72	113.358162 23.153267;113.358789 23.153617;113.358812 23.153593;113.358192 23.153241	可用
73	113.352672 23.153934;113.353129 23.153925;113.353122 23.153857;113.352667 23.15387	可用
74	113.352661 23.153798;113.352665 23.153734;113.353059 23.153736;113.353059 23.153798	可用
75	113.352141 23.153931;113.352572 23.153927;113.352574 23.153874;113.352141 23.15388	可用
76	113.352257 23.153765;113.352263 23.153715;113.352568 23.153734;113.352564 23.153783	可用
80	113.35516 23.15798;113.355596 23.157967;113.355565 23.157734;113.355132 23.157786;113.355132 23.157786;	\N
\.


--
-- Name: chargingpile; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.chargingpile', 80, true);


--
-- Name: charging_pile ChargingPile_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.charging_pile
    ADD CONSTRAINT "ChargingPile_pkey" PRIMARY KEY (cp_id);


--
-- PostgreSQL database dump complete
--
