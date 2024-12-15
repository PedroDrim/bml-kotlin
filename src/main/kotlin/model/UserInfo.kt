package model

/**
 * Informacoes do usuario
 * @param user Nome do usuario
 * @param password Senha do usuario
 */
class UserInfo(var user: String, private var _password: String){

    /**
     * Obtem a senha cryptografada do usuario
     * @return Senha cryptografada do usuario
     */
    var password: String
        get() = this._cryptPassword(this._password)
        set(value: String) { this._password = value }

    /**
     * Metodo privado para encriptar a senha do usuario
     * @param password Senha a ser encriptada
     * @return Nova senha encriptada
     */
    private fun _cryptPassword(password: String): String {
        return "HASH" + password.reversed() + "000"
    }
}