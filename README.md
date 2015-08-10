# ecommerce-backend

# Application Backend

Pour lancer le projet sur votre machine, suivez les étapes suivantes :

## Etape 1 : Créer le projet

* Cliquer sur "Projet ..."
* Sélectionner le dossier "Maven"
* Choisir l'option : "Check out Maven projects from SCM"
* Dans "SCM URL", choisir "git" et entrer "https://github.com/DTAFormation/ecommerce-backend.git" pour ceux qui travaillent en http ou "git@github.com:DTAFormation/ecommerce-backend.git" pour ceux qui travaillent en ssh"
* Cliquer directement sur "Finish"

## Etape 2 : Lancer le projet sur wildfly

* Utiliser le serveur que l'on utilisait avant</li>
* Aller dans l'onglet "Server", faire clic-droit sur le serveur, et choisir "Add and remove"
* Sélectionner "ecommerce-backend" et cliquer sur "Add >"
* Lancer le serveur

## Etape 3 : Ajouter la datasource</h2>

* Aller dans le dossier de wildfly (ça doit ressembler à "C:/wildfly")
* Aller dans le dossier "standalone"
* Ouvrir le fichier "standalone.xml" dans votre éditeur de texte préféré
* Ajouter la datasource suivante dans la liste des datasources :

``` xml
<datasource jta="false" jndi-name="java:/jdbc/datasource/ecommerceds" pool-name="ecommerce-dev" enabled="true" use-ccm="false">
  <connection-url>jdbc:mysql:///ecommerce</connection-url>
  <driver-class>com.mysql.jdbc.Driver</driver-class>
  <driver>mysql-connector-java-5.1.35-bin.jar_com.mysql.jdbc.Driver_5_1</driver>
  <security>
    <user-name>root</user-name>
  </security>
  <validation>
    <validate-on-match>false</validate-on-match>
    <background-validation>false</background-validation>
  </validation>
  <timeout>
    <set-tx-query-timeout>false</set-tx-query-timeout>
    <blocking-timeout-millis>0</blocking-timeout-millis>
    <idle-timeout-minutes>0</idle-timeout-minutes>
    <query-timeout>0</query-timeout>
    <use-try-lock>0</use-try-lock>
    <allocation-retry>0</allocation-retry>
    <allocation-retry-wait-millis>0</allocation-retry-wait-millis>
  </timeout>
  <statement>
    <share-prepared-statements>false</share-prepared-statements>
  </statement>
</datasource>
```
* Redémarrer le serveur wildfly

## Etape 4 : Déployer le mysql connector

* Ouvrir une invite de commandes WINDOWS
* Aller dans le répertoire où se situe wildfly
* Aller dans le répertoire "bin"
* Lancer jboss-cli avec la commande : "jboss-cli"
* Taper la commande "connect"
* Taper la commande "deploy C:\emplacement_du_mysql_connector.jar"

## Etape 5 : Déployer la base de données

* Ouvrir votre gestionnaire de base de données préférés (je conseille wamp, c'est de la balle)
* Créer une base de données "ecommerce"
* Aller dans l'onglet "Importer"
* Cliquer sur "Choisir un fichier ..."
* Sélectionner le fichier sql qui se trouve dans le projet

## Etape 6 : Redémarrer une dernière fois le serveur wildfly

Et hop c'est parti !
