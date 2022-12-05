import React from "react";
import GithubButton from 'react-github-login-button'
import '../../css/modal.css'

function Modal (props) {

    const { open, close, header } = props;

    const islogin = false;

    return (
        <div className={open ? 'openModal modal' : 'modal'}>
            {open ? (
                <section>
                    <header>
                        {header}GitHub 로그인
                        <button className="close" onClick={close}>
                            &times;
                        </button>
                    </header>
                    <main>
                        <div class="Github_Login">
                            <GithubButton
                                type="dark" // can be light or dark
                                onClick={() => {
                                    window.location.href = "http://localhost:8080/oauth2/authorization/github"
                                    islogin = true;
                                }
                                }
                            />
                        </div>
                    </main>
                    <footer>
                        <button class="close" onClick={close}>close</button>
                    </footer>
                </section>
            ) : null}
        </div>
    )
}

export default Modal;