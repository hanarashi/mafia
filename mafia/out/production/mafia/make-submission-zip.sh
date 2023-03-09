#!/bin/sh

touch submission.zip
rm submission.zip

zip -x ./ir/sharif/math/ap2023/mafia/Main.java -r submission.zip ir/
