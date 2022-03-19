export default function NewArticles(props) {

    return (
        <div className="newArticle__form">
            <h3 className="newArticle__title" >Ajouter un article</h3>
            <div className="newArticle__container">
                <label>Nom de la categorie : {" "} </label>
                <input
                    className="newArticle__input" 
                    type="text"
                    placeholder="Choisir un nom de categorie" 
                    name="category"
                    value={props.newArticle.name}
                    onChange={props.handleChange} 
                />
            </div>
            
            <div className="newArticle__container">
                <label>Nom de l'auteur : {" "}</label>
                <input 
                    className="newArticle__input"
                    type="text" 
                    placeholder="Choisir un nom d'auteur" 
                    name="author"
                    value={props.newArticle.name}
                    onChange={props.handleChange}
                /> 
            </div>

            <div className="newArticle__container">
                <label>Date de l'article : {" "}</label>
                <input
                    className="newArticle__input"
                    type="date" 
                    name="date"
                    value={props.newArticle.date}
                    onChange={props.handleChange}>
                </input>
            </div>
            
            <textarea
                className="newArticle__content"
                placeholder="Ecrivez quelque chose ..." 
                name="content"
                value={props.newArticle.description}
                onChange={props.handleChange} 
            />

            {props.inputInvalid && <p>{props.inputInvalid}</p>}

            <button className="newArticle__submitButton" onClick={props.submitProduct}>Nouvel Article</button>
        </div>
    )
}