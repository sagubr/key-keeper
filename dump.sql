--
-- PostgreSQL database dump
--

-- Dumped from database version 16.4 (Ubuntu 16.4-1.pgdg22.04+2)
-- Dumped by pg_dump version 17.0 (Ubuntu 17.0-1.pgdg22.04+1)

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
-- Data for Name: assignment; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO public.assignment VALUES ('36727b78-88e9-4485-8a13-08161eab8358', true, '2025-02-26 17:46:52.234561-03', '2025-02-26 17:46:52.234561-03', 0, 'Portaria');


--
-- Data for Name: assignment_screens; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO public.assignment_screens VALUES ('36727b78-88e9-4485-8a13-08161eab8358', 'EMPRESTIMOS');
INSERT INTO public.assignment_screens VALUES ('36727b78-88e9-4485-8a13-08161eab8358', 'HISTORICO');


--
-- Data for Name: configurations; Type: TABLE DATA; Schema: public; Owner: postgres
--



--
-- Data for Name: facilities; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO public.facilities VALUES ('57b8d0e2-ddb1-4904-a1e2-d3e70bc3f0ee', true, '2025-02-26 17:45:51.182771-03', '2025-02-26 17:45:51.182771-03', 0, '', 'Bloco A');
INSERT INTO public.facilities VALUES ('79902d5f-312a-4fff-8578-7916b6463f06', true, '2025-02-26 17:45:56.552688-03', '2025-02-26 17:45:56.552688-03', 0, '', 'Bloco B');


--
-- Data for Name: job_titles; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO public.job_titles VALUES ('1467a61d-4fd1-4125-b1df-a6b7f48d5488', true, '2025-02-26 17:44:50.091148-03', '2025-02-26 17:44:50.091148-03', 0, 'Docente do curso de graduação', 'Professor');
INSERT INTO public.job_titles VALUES ('815d402a-d564-444e-9cb7-9b11584c6a17', true, '2025-02-26 17:45:19.424688-03', '2025-02-26 17:45:19.424688-03', 0, 'Responsável pelos serviços administrativos', 'Secretaria');
INSERT INTO public.job_titles VALUES ('dcb43982-a532-44ba-8482-2f927f45c7a6', true, '2025-02-26 17:45:34.301017-03', '2025-02-26 17:45:34.301017-03', 0, 'Responsável pela manutenção do ambiente', 'Auxiliar de Limpeza');


--
-- Data for Name: locations_type; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO public.locations_type VALUES ('dbe5893a-ce98-433e-bd7d-9a51a5b44ec3', true, '2025-02-26 17:46:02.029899-03', '2025-02-26 17:46:02.029899-03', 0, '', 'Laboratório');
INSERT INTO public.locations_type VALUES ('8d5dd52f-7560-4b41-998e-9c1845ab8fe1', true, '2025-02-26 17:46:06.472431-03', '2025-02-26 17:46:06.472431-03', 0, '', 'Sala');
INSERT INTO public.locations_type VALUES ('ffb15085-973d-4bc0-977b-f27421b9cdb1', true, '2025-02-26 17:46:28.94618-03', '2025-02-26 17:46:28.94618-03', 0, '', 'Anfiteatro');


--
-- Data for Name: locations; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO public.locations VALUES ('abef6b38-88ca-4f60-9ed1-2b8bb88b603d', true, '2025-02-26 17:50:48.881415-03', '2025-02-26 17:50:48.881415-03', 0, NULL, '', false, false, NULL, 'Sala 1', NULL, '79902d5f-312a-4fff-8578-7916b6463f06', '8d5dd52f-7560-4b41-998e-9c1845ab8fe1');
INSERT INTO public.locations VALUES ('26ed3967-079b-4744-87a9-8aa4d629ac00', true, '2025-02-26 17:51:09.935325-03', '2025-02-26 17:51:09.935325-03', 0, NULL, '', false, false, 30, 'Sala 2', NULL, '57b8d0e2-ddb1-4904-a1e2-d3e70bc3f0ee', 'dbe5893a-ce98-433e-bd7d-9a51a5b44ec3');


--
-- Data for Name: keys; Type: TABLE DATA; Schema: public; Owner: postgres
--



--
-- Data for Name: users; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO public.users VALUES ('d7933af7-ef63-440c-ae45-9a2aaa3c7eb7', true, '2025-02-26 17:47:08.383502-03', '2025-02-26 17:47:08.383502-03', 0, 'sousagustavogarcia@gmail.com', true, 'Gustavo Garcia', '$2a$10$wCUyyRsEsxtt9mpjGukb5./n37XMqFH8kEyNpj0tMwBpdNOb4fT6O', 'gustavo.garcia', '36727b78-88e9-4485-8a13-08161eab8358');


--
-- Data for Name: permissions; Type: TABLE DATA; Schema: public; Owner: postgres
--



--
-- Data for Name: location_permission; Type: TABLE DATA; Schema: public; Owner: postgres
--



--
-- Data for Name: requesters; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO public.requesters VALUES ('3e93eff9-01e1-44a6-876d-86c757bf34cb', true, '2025-02-26 17:47:49.979834-03', '2025-02-26 17:47:49.979834-03', 0, false, false, 'Manoel Gomes', '2050', 'dcb43982-a532-44ba-8482-2f927f45c7a6');
INSERT INTO public.requesters VALUES ('f5b53b8f-27a9-412b-8c0a-9e2ab813f8e0', true, '2025-02-26 17:48:04.451479-03', '2025-02-26 17:48:04.451479-03', 0, false, false, 'Getúlio Vargas', '6040', '1467a61d-4fd1-4125-b1df-a6b7f48d5488');
INSERT INTO public.requesters VALUES ('04c35c31-e55f-49d3-8752-04badaa2ff54', true, '2025-02-26 17:49:22.673721-03', '2025-02-26 17:49:22.673721-03', 0, false, false, 'Dominic Toretto', '5690', '1467a61d-4fd1-4125-b1df-a6b7f48d5488');
INSERT INTO public.requesters VALUES ('7c04004a-ce41-4199-8fab-7228f8de7048', true, '2025-02-26 17:49:52.762151-03', '2025-02-26 17:49:52.762151-03', 0, false, true, 'Ivan Filho', '4598', '1467a61d-4fd1-4125-b1df-a6b7f48d5488');


--
-- Data for Name: location_responsible; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO public.location_responsible VALUES ('abef6b38-88ca-4f60-9ed1-2b8bb88b603d', '7c04004a-ce41-4199-8fab-7228f8de7048');


--
-- Data for Name: requester_emails; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO public.requester_emails VALUES ('3e93eff9-01e1-44a6-876d-86c757bf34cb', 'manoel@example.com');
INSERT INTO public.requester_emails VALUES ('f5b53b8f-27a9-412b-8c0a-9e2ab813f8e0', 'getulio@example.com');
INSERT INTO public.requester_emails VALUES ('04c35c31-e55f-49d3-8752-04badaa2ff54', 'dominic@example.com');
INSERT INTO public.requester_emails VALUES ('7c04004a-ce41-4199-8fab-7228f8de7048', 'ivanfilho@example.com');


--
-- Data for Name: requester_permission; Type: TABLE DATA; Schema: public; Owner: postgres
--



--
-- Data for Name: reservations; Type: TABLE DATA; Schema: public; Owner: postgres
--



--
-- PostgreSQL database dump complete
--

