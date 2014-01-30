#!/bin/bash

fichier=$1

nb_ligne="`cat $fichier|wc -l`"

liste_type="`cat $fichier |cut -d'/' -f5|sort -u`"

fichier_tmp_detail="fichier_temporaire_detail.txt"

touch $fichier_tmp_detail

echo "#### AFFICHAGE DES STATISTIQUES ####"
echo "nombre de ligne de $fichier : $nb_ligne ligne(s)"
for type in $liste_type;
do
  fichier_tmp="fichier_temporaire.txt"
  cat $fichier|egrep "^<http://data.linkedmdb.org/resource/$type/" > $fichier_tmp

  nb_ligne_par_type="`cat $fichier_tmp|wc -l`"
  nb_entite_par_type="`cat $fichier_tmp|cut -d' ' -f1|sort -u|wc -l`"

  echo "-- $type : $nb_entite_par_type entite(s)"
  echo "-- $type : $nb_ligne_par_type ligne(s)"

  echo "..:: $type ::.." >> $fichier_tmp_detail
  property_of_type=`cat $fichier_tmp |cut -d ' ' -f 2|sort -u`
  echo $property_of_type | tr ' ' '\n' >> $fichier_tmp_detail

  echo "-- * Exemples *" >> $fichier_tmp_detail
  for property in $property_of_type;
  do
    liste_random="`echo $(shuf -i 1-$nb_entite_par_type|head -n20)`"
    for random in $liste_random;
    do
      echo "((((((( $type -> $property )))))))" >> $fichier_tmp_detail
      cat $fichier_tmp | grep $property | grep "/$type/$random>" >> $fichier_tmp_detail
    done
  done
  rm -f $fichier_tmp
done

cat $fichier_tmp_detail
rm $fichier_tmp_detail
