# simple-jetty-sample
コマンドラインから起動する、Jetty 組み込みのアプリケーションサーバーのサンプル

## ビルド
```
$ ./gradlew war
```

## 実行
```
$ java -jar build/libs/sample.war 
```

ブラウザで http://localhost:8080/sample/servlet を開く

## License
MIT


