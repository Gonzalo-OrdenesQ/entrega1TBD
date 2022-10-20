DROP DATABASE IF EXISTS volunteer;

CREATE DATABASE volunteer WITH TEMPLATE = template0 ENCODING = 'UTF8';

ALTER DATABASE volunteer OWNER TO postgres;

\connect volunteer

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

CREATE TABLE IF NOT EXISTS public.voluntee(
    id SERIAL PRIMARY KEY,
    name character varying(64) COLLATE pg_catalog."default",
    email character varying(64) COLLATE pg_catalog."default",
    pass character varying(32) COLLATE pg_catalog."default"
)TABLESPACE pg_default;

CREATE TABLE IF NOT EXISTS public.skill(
    id SERIAL PRIMARY KEY,
    name character varying(32) COLLATE pg_catalog."default",
    description character varying(128) COLLATE pg_catalog."default"
)TABLESPACE pg_default;

CREATE TABLE IF NOT EXISTS public.institution(
    id SERIAL PRIMARY KEY,
    name character varying(32) COLLATE pg_catalog."default",
    addr character varying(64) COLLATE pg_catalog."default"
)TABLESPACE pg_default;

CREATE TABLE IF NOT EXISTS public.stage_task(
    id SERIAL PRIMARY KEY,
    stage character varying(32) COLLATE pg_catalog."default"
)TABLESPACE pg_default;

CREATE TABLE IF NOT EXISTS public.emergency(
    id SERIAL PRIMARY KEY,
    name character varying(64) COLLATE pg_catalog."default",
    addr character varying(64) COLLATE pg_catalog."default",
    description character varying(74) COLLATE pg_catalog."default",
    id_institution integer,
    CONSTRAINT fk_emergency_institution FOREIGN KEY (id_institution)
        REFERENCES public.institution(id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION
)TABLESPACE pg_default;

CREATE TABLE IF NOT EXISTS public.task(
    id SERIAL PRIMARY KEY,
    name character varying(32) COLLATE pg_catalog."default",
    description character varying COLLATE pg_catalog."default",
    id_emergency integer,
    id_stage_task integer,
    CONSTRAINT fk_task_emergency FOREIGN KEY (id_emergency)
        REFERENCES public.emergency (id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION,
    CONSTRAINT fk_task_stage_task FOREIGN KEY (id_stage_task)
        REFERENCES public.stage_task (id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION
)TABLESPACE pg_default;

CREATE TABLE IF NOT EXISTS public.vol_skill(
    id SERIAL PRIMARY KEY,
    id_voluntee integer,
    id_skill integer,
    CONSTRAINT fk_vol_skill_voluntee FOREIGN KEY (id_voluntee)
        REFERENCES public.voluntee (id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION,
    CONSTRAINT fk_vol_skill_skill FOREIGN KEY (id_skill)
        REFERENCES public.skill (id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION
)TABLESPACE pg_default;

CREATE TABLE IF NOT EXISTS public.eme_skill(
    id SERIAL PRIMARY KEY,
    id_emergency integer,
    id_skill integer,
    CONSTRAINT fk_eme_skill_emergency FOREIGN KEY (id_emergency)
        REFERENCES public.emergency(id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION,
    CONSTRAINT fk_eme_skill_skill FOREIGN KEY (id_skill)
        REFERENCES public.skill(id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION
)TABLESPACE pg_default;

CREATE TABLE IF NOT EXISTS public.task_skill(
    id SERIAL PRIMARY KEY,
    id_task integer,
    id_skill integer,
    CONSTRAINT fk_task_skill_task FOREIGN KEY (id_task)
        REFERENCES public.task(id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION,
    CONSTRAINT fk_task_skill_skill FOREIGN KEY (id_skill)
        REFERENCES public.skill(id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION
)TABLESPACE pg_default;

CREATE TABLE IF NOT EXISTS public.ranking(
    id SERIAL PRIMARY KEY,
    id_voluntee integer,
    id_task integer,
    score integer,
    CONSTRAINT fk_ranking_voluntee FOREIGN KEY (id_voluntee)
        REFERENCES public.voluntee(id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION,
    CONSTRAINT fk_ranking_task FOREIGN KEY (id_task)
        REFERENCES public.task(id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION
)TABLESPACE pg_default;