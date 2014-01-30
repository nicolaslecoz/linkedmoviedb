#!/bin/bash

liste_attribut="`cat $fichier |cut -d' ' -f2|sort -u`"

liste_entite="`cat $fichier|cut -d' ' -f1|sort -u`"

for entite in $liste_entite
  echo "..:: $entite ::.."
  for attribut in $liste_attribut
  do
    nb_attr_pour_entite=`cat $fichier|grep "^$entite"|grep " $attribut "|wc -l`
    echo "  $attribut -> $nb_attr_pour_entite"
  done
do
