# This Repository contains the results of our evaluation of isiSPL

(this repository is currently a work in progress)

The content of this repository will be submitted as paper's _Artefact_ .


Each folder contains the results produced by isiSPL, when applied on the set of products. 

## Folder Structure :
-| **original_Products** : contains the original product files used by integrated by isiSPL.

-| **Results** : the IsiSPL results

----| **0_debug** : a debug version of the annotated code of the SPL implementation, produced by isiSPL. This version shows an annotation around every artefact and display the Artefact's ID. 

----| **Configurations** : the configuration of the original products as determined by isiSPL.

----|----| **ArtefactsConfig** : the artefact configuration, i.e. the list of all the artefacts identified by isiSPL in a product.

----|----| **FeaturesConfig** : the feature configuration, i.e. the list of all the feature in a product (as informed by the developers).

----| **Experimentation** : the reproduced product from our validation, as described inside our paper. 

----|----| **reproduced_Products** : the reproduced products generated from isiSPL based on our experimentation protocole. 


----| **SPL_Annotated_Code** : the final isiSPL's generated Annotated Code for the SPL implementation. (**Note** : in this current version, the full simplification described in our paper as not been fully implemented) 


### Special Files : 

**PCM-Artefact** : the *Product Configuration Matrice* file of the artefacts of the SPL. 

**variabilityModelArtefact** : the variablity model of the artefacts (made in *dot*)

**PCM-Feature** : the *Product Configuration Matrice* file of the features of the SPL. 

**variabilityModelFeature** : the variablity model of the features (made in *dot*)

**SPL-comparison** : results of the comparison between the original products and the reproduced product, generated from isiSPL (see our protocol)













