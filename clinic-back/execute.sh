#!/bin/bash

cd db && docker build -t db . && docker run -p 5432:5432 db 

