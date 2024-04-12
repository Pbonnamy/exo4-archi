On a décider de faire une interface Exporter implémenter par :
    - JsonExporter afin d'enregistrer les données dans un fichier json
    - ConsoleExporter afin d'afficher les données dans la console

On a également créer une interface Parser implémenter par :
    - JsonParser afin de lire les données depuis un fichier json

Ces interfaces nous permettront à l'avenir de facilement ajouter de nouveaux formats d'exportation et de lecture de données.

En terme d'objets métiers on a créer :
- Un objet TodoList qui contient une liste de Todo
- Un objet Todo qui contient une description, une date et un statut (fait ou non fait)

Enfin on créer un Enum Action qui contient les différentes actions possibles pour le programme :
- ADD pour ajouter une tâche
- REMOVE pour supprimer une tâche
- LIST pour afficher la liste des tâches
- DONE pour marquer une tâche comme faite

Nous avons tenté d'implémenter une factory pour les actions afin de découpler la création des actions de la classe principale du programme mais nous n'avons pas eu assez de temps pour concrétiser cette idée.
De plus nous avons également tenté une version avec un handler et une classe pour chaque action (disponible sur la branche "test")
