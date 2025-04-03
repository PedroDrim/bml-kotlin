#!/bin/bash
mv build/native/nativeCompile/bml-kotlin ./bml-kotlin
chmod +x bml-kotlin

./bml-kotlin config.json > /dev/null
cat benchmark.json