export default function NewProduct(props) {

    return (
        <div className="newCategory__form">
            <h3 className="newCategory__title" >Ajouter une categorie</h3>
            <div className="newCategory__container">
                <label>Nom de la categorie : {" "} </label>
                <input
                    className="newCategory__input" 
                    type="texte"
                    placeholder="Choisir un nom" 
                    name="nom"
                    value={props.newCategory.name}
                    onChange={props.handleChange} 
                />
            </div>
            {props.inputInvalid && <p>{props.inputInvalid}</p>}

            <button className="newCategory__submitButton" onClick={props.submitCategory}>Nouvelle Categorie</button>
        </div>
    )
}