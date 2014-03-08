def class Country {
    String name;
    String currency;
    String code;
    String capital;
    String continent;
    String population;
    String areaInSqKm;
    String id;
    String iso_numeric;
    String iso_alpha2;
    String iso_alpha3;

    public String toString() {
        StringBuilder buffer = new StringBuilder()

        buffer.append("(")
        buffer.append(name).append(",")
        buffer.append(currency).append(",")
        buffer.append(code).append(",")
        buffer.append(capital).append(",")
        buffer.append(continent).append(",")
        buffer.append(population).append(",")
        buffer.append(id).append(",")
        buffer.append(iso_numeric).append(",")
        buffer.append(iso_alpha2).append(",")
        buffer.append(iso_alpha2).append(",")
        buffer.append(")")
        return buffer.toString()
    }
}

private String calculerCle(String ligne) {
    return ligne.substring(44,46)
}

private void setValueOnCountryByReflection(Country country, String attr, String value) {
    Country.class.getDeclaredField("")
}

println("..:: Generation du sql pour les country ::..")

def File f = new File("./linkedmdb-latest-dump.nt_country")
def mapValue = [:]


f.eachLine { ligne ->
    println("ligne:$ligne")

    cle = calculerCle(ligne)

    if (mapValue[cle] == null) {
        mapValue[cle] = new Country()
    }


}

mapValue["test"]=new Country()

mapValue.each {cle ->
    println("cle=$cle")
}

println("..:: traitement termine ::..")

/* generation du fichier avec cette commande :

cat linkedmdb-latest-dump.nt |egrep "^<http://data.linkedmdb.org/resource/country/[a-zA-Z]*>"|grep "http://data.linkedmdb.org/resource/movie/country_" > linkedmdb-latest-dump.nt_country


<http://data.linkedmdb.org/resource/country/SA> <http://data.linkedmdb.org/resource/movie/country_currency> "SAR" .
<http://data.linkedmdb.org/resource/country/SA> <http://data.linkedmdb.org/resource/movie/country_name> "Saudi Arabia" .
<http://data.linkedmdb.org/resource/country/SA> <http://data.linkedmdb.org/resource/movie/country_fips_code> "SA" .
<http://data.linkedmdb.org/resource/country/SA> <http://data.linkedmdb.org/resource/movie/country_capital> "Riyadh" .
<http://data.linkedmdb.org/resource/country/SA> <http://data.linkedmdb.org/resource/movie/country_iso_numeric> "682" .
<http://data.linkedmdb.org/resource/country/SA> <http://data.linkedmdb.org/resource/movie/country_languages> "ar-SA" .
<http://data.linkedmdb.org/resource/country/SA> <http://data.linkedmdb.org/resource/movie/country_continent> "AS" .
<http://data.linkedmdb.org/resource/country/SA> <http://data.linkedmdb.org/resource/movie/country_population> "28161000" .
<http://data.linkedmdb.org/resource/country/SA> <http://data.linkedmdb.org/resource/movie/country_areaInSqKm> "1960582"^^<http://www.w3.org/2001/XMLSchema#double> .
<http://data.linkedmdb.org/resource/country/SA> <http://data.linkedmdb.org/resource/movie/country_iso_alpha2> "SA" .
<http://data.linkedmdb.org/resource/country/SA> <http://data.linkedmdb.org/resource/movie/country_id> "1"^^<http://www.w3.org/2001/XMLSchema#int> .
<http://data.linkedmdb.org/resource/country/SA> <http://data.linkedmdb.org/resource/movie/country_iso_alpha3> "SAU" .
<http://data.linkedmdb.org/resource/country/YT> <http://data.linkedmdb.org/resource/movie/country_currency> "EUR" .
<http://data.linkedmdb.org/resource/country/YT> <http://data.linkedmdb.org/resource/movie/country_name> "Mayotte" .
<http://data.linkedmdb.org/resource/country/YT> <http://data.linkedmdb.org/resource/movie/country_fips_code> "MF" .
<http://data.linkedmdb.org/resource/country/YT> <http://data.linkedmdb.org/resource/movie/country_capital> "Mamoudzou" .
<http://data.linkedmdb.org/resource/country/YT> <http://data.linkedmdb.org/resource/movie/country_iso_numeric> "175" .
<http://data.linkedmdb.org/resource/country/YT> <http://data.linkedmdb.org/resource/movie/country_languages> "fr-YT" .
<http://data.linkedmdb.org/resource/country/YT> <http://data.linkedmdb.org/resource/movie/country_continent> "AF" .
<http://data.linkedmdb.org/resource/country/YT> <http://data.linkedmdb.org/resource/movie/country_population> "159042" .
<http://data.linkedmdb.org/resource/country/YT> <http://data.linkedmdb.org/resource/movie/country_areaInSqKm> "374"^^<http://www.w3.org/2001/XMLSchema#double> .
<http://data.linkedmdb.org/resource/country/YT> <http://data.linkedmdb.org/resource/movie/country_iso_alpha2> "YT" .
<http://data.linkedmdb.org/resource/country/YT> <http://data.linkedmdb.org/resource/movie/country_id> "2"^^<http://www.w3.org/2001/XMLSchema#int> .
<http://data.linkedmdb.org/resource/country/YT> <http://data.linkedmdb.org/resource/movie/country_iso_alpha3> "MYT" .

*/
