# Food4Help - Progetto TAASS 21/22
La Web app "Food4Help" ha lo scopo di mettere in contatto realtà lavorative in cui lo spreco di cibo potrebbe essere ingente (Ristoranti, Bar, Panetterie, Pasticcerie, Hotel etc..) e associazioni benefiche (Caritas, Humanitas etc..) al fine di ridurre lo spreco di cibo e facilitare il processo di riutilizzo.

Le tipologie di utente sono due: 

  WorkingActivity: genera box contenenti del cibo con una serie di informazioni e le pubblica sull'applicativo
  CharityActivity: controlla le box che qualche WorkingActivity ha pubblicato e procede alla prenotazione

  ## food4help-be
  Il microservizio userService pone il focus sulla gestione della registrazione dell'utente.
  La business logic comprende: 
    rappresentazione object oriented della super classe utente e delle sotto classi CharityActivity e WorkActivity
    gestione della persistenza.
  Di seguito i comandi per l'esecuzuone

    ### Esecuzione
    Dopo aver caricato l'immagine su docker con i seguenti comandi:
      - ./mvnw -DskipTests=true clean package      
      - docker-compose build
    Eseguiamo il microservizio su Kubernetes:
      - kubectl apply -f kube
      - kubectl port-forward deployment/appuser 8080:8080
  ## boxService
  
  Il microservizio permette la gestione delle persistenza e del controllo degli oggetti Box creati a run time
  
     ### Esecuzione
      Dopo aver caricato l'immagine su docker con i seguenti comandi:
      - ./mvnw -DskipTests=true clean package      
      - docker-compose build
    Eseguiamo il microservizio su Kubernetes:
      - kubectl apply -f kube
      - kubectl port-forward deployment/appbox 8082:8080
      
  ## reservationService
  
    Il microservizio permette la gestione delle persistenza e del controllo degli oggetti Reservation creati a run time
  
     ### Esecuzione
      Dopo aver caricato l'immagine su docker con i seguenti comandi:
      - ./mvnw -DskipTests=true clean package      
      - docker-compose build
    Eseguiamo il microservizio su Kubernetes:
      - kubectl apply -f kube
      - kubectl port-forward deployment/appres 8083:8080
      
      
  ## GatewayAPI
  
  L'API Gateway utilizzato è quello base derivante dallo SpringInitializer, il quale è stato costruito on top dell'ecosistema Spring.
  Una volta definite le routes su cui fare match, il funzionamento è trasparente al client.
  
     ### Esecuzione
      Essendo in locale è sufficiente avviarlo come progetto semplice da IntelliJ
      
      
  ## RabbitMQ 
  Nel caso in cui si utilizzi una macchina Windows con Docker Desktop controllare nel file application.properties la riga spring.rabbitmq.host inserendo l'ip della docker machine.
    - Analytics
    - msgBrokersrv
