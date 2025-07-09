--
-- PostgreSQL database dump
--

-- Dumped from database version 17.5 (Debian 17.5-1.pgdg120+1)
-- Dumped by pg_dump version 17.5 (Debian 17.5-1.pgdg120+1)

SET statement_timeout = 0;
SET lock_timeout = 0;
SET idle_in_transaction_session_timeout = 0;
SET transaction_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SELECT pg_catalog.set_config('search_path', '', false);
SET check_function_bodies = false;
SET xmloption = content;
SET client_min_messages = warning;
SET row_security = off;

--
-- Name: employee_performance; Type: DATABASE; Schema: -; Owner: user
--

CREATE DATABASE employee_performance WITH TEMPLATE = template0 ENCODING = 'UTF8' LOCALE_PROVIDER = libc LOCALE = 'en_US.utf8';


ALTER DATABASE employee_performance OWNER TO "user";

\connect employee_performance

SET statement_timeout = 0;
SET lock_timeout = 0;
SET idle_in_transaction_session_timeout = 0;
SET transaction_timeout = 0;
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
-- Name: department; Type: TABLE; Schema: public; Owner: user
--

CREATE TABLE public.department (
    id bigint NOT NULL,
    budget double precision,
    name character varying(255)
);


ALTER TABLE public.department OWNER TO "user";

--
-- Name: employee; Type: TABLE; Schema: public; Owner: user
--

CREATE TABLE public.employee (
    id bigint NOT NULL,
    date_of_joining date,
    email character varying(255) NOT NULL,
    name character varying(255),
    salary double precision,
    department_id bigint,
    manager_id bigint
);


ALTER TABLE public.employee OWNER TO "user";

--
-- Name: employee_project; Type: TABLE; Schema: public; Owner: user
--

CREATE TABLE public.employee_project (
    assigned_date date,
    role character varying(255),
    employee_id bigint NOT NULL,
    project_id bigint NOT NULL
);


ALTER TABLE public.employee_project OWNER TO "user";

--
-- Name: performance_review; Type: TABLE; Schema: public; Owner: user
--

CREATE TABLE public.performance_review (
    id bigint NOT NULL,
    review_comments character varying(255),
    review_date date,
    score integer,
    employee_id bigint
);


ALTER TABLE public.performance_review OWNER TO "user";

--
-- Name: project; Type: TABLE; Schema: public; Owner: user
--

CREATE TABLE public.project (
    id bigint NOT NULL,
    end_date date,
    name character varying(255),
    start_date date,
    department_id bigint
);


ALTER TABLE public.project OWNER TO "user";

--
-- Data for Name: department; Type: TABLE DATA; Schema: public; Owner: user
--

COPY public.department (id, budget, name) FROM stdin;
1	5000000	Engineering
2	2000000	Marketing
3	1000000	HR
\.


--
-- Data for Name: employee; Type: TABLE DATA; Schema: public; Owner: user
--

COPY public.employee (id, date_of_joining, email, name, salary, department_id, manager_id) FROM stdin;
1001	2020-01-15	alice.manager@example.com	Alice Manager	150000	1	\N
1002	2021-03-20	bob.eng@example.com	Bob Engineer	90000	1	1001
1003	2022-05-12	charlie.marketing@example.com	Charlie Marketer	75000	2	1001
1004	2023-02-01	diana.hr@example.com	Diana HR	60000	3	1001
\.


--
-- Data for Name: employee_project; Type: TABLE DATA; Schema: public; Owner: user
--

COPY public.employee_project (assigned_date, role, employee_id, project_id) FROM stdin;
2024-01-05	Lead Developer	1002	101
2024-03-10	Marketing Analyst	1003	102
2024-06-10	HR Coordinator	1004	103
\.


--
-- Data for Name: performance_review; Type: TABLE DATA; Schema: public; Owner: user
--

COPY public.performance_review (id, review_comments, review_date, score, employee_id) FROM stdin;
201	Excellent technical delivery	2024-12-15	9	1002
202	Creative marketing strategies	2024-09-20	8	1003
203	Strong HR support	2024-11-30	7	1004
\.


--
-- Data for Name: project; Type: TABLE DATA; Schema: public; Owner: user
--

COPY public.project (id, end_date, name, start_date, department_id) FROM stdin;
101	2024-12-31	AI System	2024-01-01	1
102	2024-09-30	Ad Campaign	2024-03-01	2
103	2024-11-30	Employee Portal	2024-06-01	3
\.


--
-- Name: department department_pkey; Type: CONSTRAINT; Schema: public; Owner: user
--

ALTER TABLE ONLY public.department
    ADD CONSTRAINT department_pkey PRIMARY KEY (id);


--
-- Name: employee employee_pkey; Type: CONSTRAINT; Schema: public; Owner: user
--

ALTER TABLE ONLY public.employee
    ADD CONSTRAINT employee_pkey PRIMARY KEY (id);


--
-- Name: employee_project employee_project_pkey; Type: CONSTRAINT; Schema: public; Owner: user
--

ALTER TABLE ONLY public.employee_project
    ADD CONSTRAINT employee_project_pkey PRIMARY KEY (employee_id, project_id);


--
-- Name: performance_review performance_review_pkey; Type: CONSTRAINT; Schema: public; Owner: user
--

ALTER TABLE ONLY public.performance_review
    ADD CONSTRAINT performance_review_pkey PRIMARY KEY (id);


--
-- Name: project project_pkey; Type: CONSTRAINT; Schema: public; Owner: user
--

ALTER TABLE ONLY public.project
    ADD CONSTRAINT project_pkey PRIMARY KEY (id);


--
-- Name: employee ukfopic1oh5oln2khj8eat6ino0; Type: CONSTRAINT; Schema: public; Owner: user
--

ALTER TABLE ONLY public.employee
    ADD CONSTRAINT ukfopic1oh5oln2khj8eat6ino0 UNIQUE (email);


--
-- Name: employee_project fk4yddvnm7283a40plkcti66wv9; Type: FK CONSTRAINT; Schema: public; Owner: user
--

ALTER TABLE ONLY public.employee_project
    ADD CONSTRAINT fk4yddvnm7283a40plkcti66wv9 FOREIGN KEY (project_id) REFERENCES public.project(id);


--
-- Name: performance_review fk9159yuocyhexftv11wmay20cg; Type: FK CONSTRAINT; Schema: public; Owner: user
--

ALTER TABLE ONLY public.performance_review
    ADD CONSTRAINT fk9159yuocyhexftv11wmay20cg FOREIGN KEY (employee_id) REFERENCES public.employee(id);


--
-- Name: employee_project fkb25s5hgggo6k4au4sye7teb3a; Type: FK CONSTRAINT; Schema: public; Owner: user
--

ALTER TABLE ONLY public.employee_project
    ADD CONSTRAINT fkb25s5hgggo6k4au4sye7teb3a FOREIGN KEY (employee_id) REFERENCES public.employee(id);


--
-- Name: employee fkbejtwvg9bxus2mffsm3swj3u9; Type: FK CONSTRAINT; Schema: public; Owner: user
--

ALTER TABLE ONLY public.employee
    ADD CONSTRAINT fkbejtwvg9bxus2mffsm3swj3u9 FOREIGN KEY (department_id) REFERENCES public.department(id);


--
-- Name: project fkl7ga8i4ry2amd4mb525tdmjf6; Type: FK CONSTRAINT; Schema: public; Owner: user
--

ALTER TABLE ONLY public.project
    ADD CONSTRAINT fkl7ga8i4ry2amd4mb525tdmjf6 FOREIGN KEY (department_id) REFERENCES public.department(id);


--
-- Name: employee fkou6wbxug1d0qf9mabut3xqblo; Type: FK CONSTRAINT; Schema: public; Owner: user
--

ALTER TABLE ONLY public.employee
    ADD CONSTRAINT fkou6wbxug1d0qf9mabut3xqblo FOREIGN KEY (manager_id) REFERENCES public.employee(id);


--
-- PostgreSQL database dump complete
--

