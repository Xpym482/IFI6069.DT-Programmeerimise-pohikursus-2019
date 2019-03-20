# Objektorienteeritud programmeerimine
Kursuse vältel omandame enamusjaolt objektorienteeritud programmeerimise põhimõtteid. Objektorienteeritud programmeerimisel on neli põhiprintsiipi milleks on kapseldus, abstraktsus, pärilus ja polümorfism. Uute informaatikute jaoks võivad need kõlada hirmutavalt kuid nende taga olev põhimõte on üpris lihtne.

## Kapseldus
Kapseldus hõlmab enda sisse erinevate komponentide loogilist eraldamist “klassidesse” mis hoiavad enda seest mingit klassi eksemplari sisaldavat andmeid ja nende funktsionaalsust. Samuti defineeritakse klasside vahelisi suhtlusreegleid teise klasside eksemplaride vahel. Võtame näiteks klassid mis selgitavad inimese ja kassi vahelist suhtlust. Kassil on oma olek mis kirjeldab tema tuju ja nälga. Kassil on funktsionaalsus nagu magamine ja mängimine mis tõstevad tema oleku parameetreid milleks on tuju ja nälg. Inimesel on funktsionaalsus mis lubab toita kassi ja mängida temaga kuid tal puudub õigus kassi parameetreid otse muuta. 

## Abstraktsioon
Abstraktsioon on põhimõte mille käigus hoitakse klasside definitsiooni ja selle implementatsiooni eraldi ja peidetuna. Sarnane sellele kuida telefonil nuppudele vajutades me ei tea, mis toimub telefoni sisemuses, need detailid on ära peidetud kuid me teame et mingi sisendi puhul (nupule vajutamine) toimub mingi kindel tulemus.

## Pärilus
Pärilus aitab meil hoiduda sarnase koodi kirjutamist juhul kui need erinevad jupid on loogiliselt sama ülesehitusega kuid sisaldavad erinevusi. Selle jaoks luuakse üks peaklass (parent class) ja alamklass (child class), mis omandab endasse peaklassi omadusi ja funktsionaalsust, kuid saab neid vabalt muuta ülekirjutades. Võtame näiteks ühe Inimese klassi mis sisaldab nime ja emaili. Peaklassi Inimene alamklassiks võib võtta Tudengi ja Õppejõu klassid. Tudengi klass sisaldab kõike mis on Inimese klassis aga sisaldab hindeid ja aineid mida ta kuulab. Õppejõu klass sisaldab samuti neid andmeid mis on Inimese klassis aga omab veeld andmeid ainete kohta mida ta õpetab.

## Polümorfism
Polümorfism on loodud selleks, et saaksime garanteerida alamklasside mingit sisu, mis on meile vajalik, kuid mismoodi see täpsemalt on implementeeritud ei ole tähtis. Sealhulgas peavad kõikide alamklaaside funktsionaalsust rakendavad funktsioonid olema kättesaadavalt ühise nime alt. Võtame näiteks geomeetrilised kujundid. Vajalik on see, et iga alamklass defineeriks pindala() ja läbimõõdu() funktsioonid kuid mismoodi alamklassid Kolmnurk, Ring või Ruut seda teevad pole meile tähtis.
