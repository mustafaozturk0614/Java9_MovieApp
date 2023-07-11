# DOCKER KULLANIMI

## IMAGE OLUSTURMA
    docker build --build-arg JAR_FILE=<build path >-t <image name> .
    docker build --build-arg JAR_FILE=build/libs/Java9_MovieApp-0.0.1-SNAPSHOT.jar -t movieapp:v001 .
    build path: servisimizden build aldığımız zaman oluşan jar dosyasının konumu
    image name: oluşturacağımız image e vereceğimiz isim ( versiyon numarası vermeyi unutmayın !!! )
## IMAGE UZERİNDEN CONTAINER CALISTIRMA
    docker run -d -p dısport:içport movieapp:v001
    docker run -d -p 8094:8093 movieapp:v001
    içport: application yml da uygulamanın ayağa kalktığı port
    dışport: containerın dışarıya açıldığı port istekler bu porta gelecek bu port iç porta yonlendirecek
    docker run --name java9postgres -e POSTGRES_PASSWORD=root -d -p 5959:5432 postgres (dockerhub uzerinden 
     run komutuyla beraber postgres image dosyası cekilip bu komutla beraber çalışmaktadır burda databse e baglanma
      şifresini  - e olarak bir environment olarak tanımladık)
## NETWORK OLUSTURMA
    docker network ls: var olan networklerimizi listeleme
    docker network rm somenetwork : network adıyla networkumuzu silme
    docker network create --driver bridge --subnet <ag portları > --gateway 182.18.0.1 < network name>
    1- docker network create --driver bridge --subnet 182.18.0.1/24 --gateway 182.18.0.1 java9-network
    2-docker network create --driver bridge --subnet 192.168.3.1/24  --gateway 192.168.3.1 java9-network
    iki kodda aynı işlevi yapmaktadır burda farklı subnetler verilebileceğini gostermek için tekrar başka 
    subnet ler ile aynı kodu yazdım                                                     
    ag portları: networkumuzdeki ip aralığını belirlediğmiz yer
    network create komutu ile bir network olusturabiliriz
### NETWORKE CONTAINER BAGLAMA
    docker run --name java9postgres -e POSTGRES_PASSWORD=root --net java9-network -d -p 5959:5432 postgres
    java9postgres adında bir postgresl container'ı olusturduk 
    --net java9-network komutu ile olusturdugumuz java9-network 'une  postgresqlimizi bağladık
    daha sonra apllication yml da db_url imizi değiştirdik
    url: jdbc:postgresql://localhost:5959/java9Movie_App_Db yerine artık 
    jdbc:postgresql://java9postgres/java9Movie_App_Db yazdık burda 
    localhost yerine aslında olusturdugumuz postgresql containernın ismini verdik 
    ve pg adminden register ile 5959 daki postgeslimize bağlandık ve java9Movie_App_Db adında bir databse olusturduk
    daha sonra uygulamamızı tekrar build edip uygulamamızdan bir image olusturduk 
    docker build --build-arg JAR_FILE=build/libs/Java9_MovieApp-0.0.1-SNAPSHOT.jar -t movieapp:v003 .
    ve bu image'i çalıstırıken olusturduğumuz java9-networkune asagıdaki kodla bağladık
    docker run --net java9-network -d -p 8690:8390 movieapp:v003 
