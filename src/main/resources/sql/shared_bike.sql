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
-- Name: sharedbike; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.sharedbike
    START WITH 0
    INCREMENT BY 1
    MINVALUE 0
    MAXVALUE 9000000000
    CACHE 1;


ALTER TABLE public.sharedbike OWNER TO postgres;

SET default_tablespace = '';

SET default_table_access_method = heap;

--
-- Name: shared_bike; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.shared_bike (
    sb_id integer DEFAULT nextval('public.sharedbike'::regclass) NOT NULL,
    no character varying NOT NULL,
    state character varying NOT NULL,
    monthly_usage_times integer NOT NULL,
    lng real NOT NULL,
    lat real NOT NULL
);


ALTER TABLE public.shared_bike OWNER TO postgres;

--
-- Data for Name: shared_bike; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.shared_bike (sb_id, no, state, monthly_usage_times, lng, lat) FROM stdin;
0	NO.700000	维修中	19	113.36465	23.159336
1	NO.700001	维修中	12	113.364174	23.159079
6	NO.700006	维修中	15	113.36486	23.159063
10	NO.700010	维修中	2	113.36414	23.159117
12	NO.700012	维修中	6	113.364586	23.159744
14	NO.700014	维修中	11	113.36435	23.159468
21	NO.700021	维修中	5	113.36469	23.15998
22	NO.700022	维修中	7	113.36407	23.159441
29	NO.700029	维修中	2	113.364876	23.159101
34	NO.700034	维修中	3	113.36479	23.159563
36	NO.700036	维修中	14	113.36479	23.15974
39	NO.700039	维修中	4	113.36453	23.159748
45	NO.700045	维修中	0	113.36486	23.159609
52	NO.700050	停车中	20	113.36491	23.15957
53	NO.700051	停车中	20	113.36491	23.15959
54	NO.700052	停车中	20	113.36491	23.1596
55	NO.700053	停车中	20	113.36491	23.15962
56	NO.700054	停车中	20	113.36491	23.15965
57	NO.700056	停车中	20	113.36491	23.15967
59	NO.700057	停车中	20	113.36491	23.15972
60	NO.700058	停车中	20	113.36491	23.15974
61	NO.700059	停车中	20	113.36491	23.15977
58	NO.700060	停车中	20	113.36491	23.1597
2	NO.700002	正在使用中	0	113.36442	23.159817
3	NO.700003	正在使用中	3	113.364975	23.15943
4	NO.700004	正在使用中	1	113.36463	23.159424
5	NO.700005	正在使用中	3	113.364265	23.159023
7	NO.700007	正在使用中	11	113.36431	23.15914
8	NO.700008	正在使用中	8	113.3645	23.15917
9	NO.700009	正在使用中	0	113.36445	23.15963
11	NO.700011	正在使用中	5	113.36494	23.15948
13	NO.700013	正在使用中	10	113.36402	23.159185
15	NO.700015	正在使用中	4	113.364586	23.159487
16	NO.700016	正在使用中	4	113.36423	23.159594
17	NO.700017	正在使用中	1	113.36466	23.15925
18	NO.700018	正在使用中	19	113.36423	23.159752
19	NO.700019	正在使用中	14	113.36458	23.15951
20	NO.700020	正在使用中	8	113.36492	23.15964
23	NO.700023	正在使用中	4	113.36483	23.159575
24	NO.700024	正在使用中	15	113.36401	23.159609
25	NO.700025	正在使用中	15	113.36496	23.159678
26	NO.700026	正在使用中	10	113.364296	23.159925
27	NO.700027	正在使用中	14	113.36474	23.159264
28	NO.700028	正在使用中	13	113.36438	23.159977
30	NO.700030	正在使用中	18	113.36444	23.159473
31	NO.700031	正在使用中	14	113.36453	23.159595
32	NO.700032	正在使用中	14	113.364716	23.159063
33	NO.700033	正在使用中	5	113.36415	23.159054
35	NO.700035	正在使用中	18	113.36448	23.15941
37	NO.700037	正在使用中	1	113.36465	23.159689
38	NO.700038	正在使用中	0	113.364426	23.159098
40	NO.700040	正在使用中	16	113.36428	23.159273
41	NO.700041	正在使用中	10	113.36491	23.15909
42	NO.700042	正在使用中	13	113.36494	23.159002
43	NO.700043	正在使用中	13	113.36488	23.159754
44	NO.700044	正在使用中	1	113.36462	23.159788
46	NO.700046	正在使用中	13	113.36456	23.159687
47	NO.700047	正在使用中	15	113.36491	23.15956
48	NO.700048	正在使用中	19	113.36438	23.159878
49	NO.700049	正在使用中	3	113.364174	23.159445
51	tsw2	更新3	0	65	45.987
62	HN111111	正在使用中	10	113.353546	23.157993
\.


--
-- Name: sharedbike; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.sharedbike', 62, true);


--
-- Name: shared_bike SharedBike_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.shared_bike
    ADD CONSTRAINT "SharedBike_pkey" PRIMARY KEY (sb_id);


--
-- PostgreSQL database dump complete
--

