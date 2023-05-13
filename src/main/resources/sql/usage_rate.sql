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

SET default_tablespace = '';

SET default_table_access_method = heap;

--
-- Name: usage_rate; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.usage_rate (
    us_id integer NOT NULL,
    month integer NOT NULL,
    total_usage integer NOT NULL,
    day integer NOT NULL
);


ALTER TABLE public.usage_rate OWNER TO postgres;

--
-- Data for Name: usage_rate; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.usage_rate (us_id, month, total_usage, day) FROM stdin;
2	2	19000	29
3	3	20000	31
4	4	10065	30
1	1	18000	31
5	5	10500	31
6	6	11000	30
7	7	12000	31
8	8	14000	31
9	9	14500	30
10	10	18000	31
11	11	16400	30
12	12	21300	31
\.


--
-- Name: usage_rate usage_rate_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.usage_rate
    ADD CONSTRAINT usage_rate_pkey PRIMARY KEY (us_id);


--
-- PostgreSQL database dump complete
--

