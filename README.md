# SLPS Scheduling System

SLPS is a scheduling app designed for home health workers, although at this point it could be easily adapted for use by anyone that needs to plan out a travel/work schedule that varies from day to day.

It currently has two front end UIs. One is designed for overall administration and registration, and the other is the client side meant to be used for planning the schedule.

## Quick Start

The project is still very much in development. It is structured in modules, most of which are Spring Boot/Java modules. The slps-ui module is an Angular app which runs the client/therapist front end. The Maven build plugin should build the entire app including node/npm parts, but I have not tested this yet. The Spring Boot portion runs on port 8080 and the Angular portion on port 4200 of the local host.

## Goals

I would like for this to eventually become more useful and encompass many of the functions of current home health software such as billing, medical records and communications with hospitals, doctors, patients, etc. Another big goal is for the scheduling system to provide details about work time and driving times to keep therapist productivity within certain constraints. For now, it has basic functionality 
