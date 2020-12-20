Для установки dummy-connector.
Находясь в директории файла dummy-connector.jar выполнить следжующую команду(для Windows)

mvn install:install-file^
-Dfile=dummy-connector.jar^
-DgroupId=com.h^
-DartifactId=dummy-connector^
-Dversion=1.0 -Dpackaging=jar^



Находясь в директории проекта выполнить следующие команды(для Windows)
java -jar JAR\Main_1-1.0-SNAPSHOT-jar-with-dependencies.jar
java -jar JAR\Main_2-1.0-SNAPSHOT-jar-with-dependencies.jar "text.txt"