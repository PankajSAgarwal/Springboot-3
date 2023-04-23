# graphiql
http://localhost:9999/graphiql

## use sdkman to use graalvm 17
<code>sdk use java 22.3.r17-grl</code>

### compile to native graalvm
<code>./gradlew nativeCompile</code>

## Native code is stored at
<code>./build/native/nativeCompile</code>

## Run Native code
<code>./build/native/nativeCompile/client</code>

## Check memory footprint used by native code

<code>ps -o rss \< pid \></code>

### Query : customers by name

<code>query{
customerByName(name:"Pankaj"){
id, name
}
}</code>

### Query : get ids of all customers

<code>query {
  customers{
    id
  }
}</code>

### Query : get ids and profile id of all customers

<code>query {
  customers{
    id, profile{
      id
    }
  }
}</code>

