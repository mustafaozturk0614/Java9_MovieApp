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