#!/bin/bash

protoc --java_out=server/src/main/java/ ./addressbook.proto
protoc --js_out=import_style=commonjs,binary:./client/ ./addressbook.proto
