Learning for MyBatis
===

MyBatisの学習リポジトリです。

## 実行方法

1. MySQLの起動

```
cd ./docker
docker-compose up
```

2. テストの実行

IDEから `./src/test/java/com/example/firstexample/FirstExampleTest.java` を実行または、以下のコマンドを実行。

```
./gradlew check
```

## 各種ファイル

設定ファイル

- [./src/main/resources/mybatis-config.xml](./src/main/resources/mybatis-config.xml)

マッパーXML

- [./src/main/resources/mapper](./src/main/resources/mapper)
