## Pre-requisite to compile to graalvm native code
jdk should point to graalvm 

<code>
sdk use java 22.3.r17-grl
</code>

## Compile to graalvm native code
<code>
./gradlew nativeCompile
</code>

## Native code is stored at 
<code>./build/native/nativeCompile</code>

## Run Native code
<code>./build/native/nativeCompile/service</code>

## Check memory footprint used by native code

<code>
ps -o rss \< pid \>
</code>