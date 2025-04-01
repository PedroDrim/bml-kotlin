# Buil alpine
FROM alpine:3.14 AS build

# Create build directory
WORKDIR /build

# Copy files to directory
COPY ./data /build/

# Descompando arquivos de simulacao
RUN unzip simulationInput_D.zip -d .

FROM findepi/graalvm:java21-native

# Create app directory
WORKDIR /app

# Copy files to directory
COPY ./ /app/

# Copiando tudo para deploy
COPY --from=build ./build /app/data

# Instalando pacotes
RUN ./gradlew test && ./gradlew nativeCompile

# Iniciando CLI
ENTRYPOINT ["sh","Bench.sh"]
