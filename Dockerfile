FROM findepi/graalvm:java21-native

# Create app directory
WORKDIR /app

# Copy files to directory
COPY ./ /app/

# Instalando pacotes
RUN ./gradlew test && ./gradlew nativeCompile

# Iniciando CLI
ENTRYPOINT ["sh","Bench.sh"]
