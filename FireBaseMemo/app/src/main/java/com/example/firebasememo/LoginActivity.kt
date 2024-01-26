package com.example.firebasememo

import android.content.Intent
import android.os.Bundle
import android.os.PersistableBundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.firebasememo.databinding.ActivityLoginBinding
import com.example.firebasememo.databinding.ActivityUserBinding
import com.firebase.ui.auth.AuthUI
import com.firebase.ui.auth.FirebaseAuthUIActivityResultContract
import com.firebase.ui.auth.data.model.FirebaseAuthUIAuthenticationResult
import com.google.firebase.auth.FirebaseAuth

class LoginActivity : AppCompatActivity() {

    private lateinit var binding: ActivityLoginBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.authButton.setOnClickListener {
            // 認証プロバイダー設定
            val providers = arrayListOf(
                AuthUI.IdpConfig.GoogleBuilder().build(),
                AuthUI.IdpConfig.EmailBuilder().build() ,

            )

            // サインインインテントをランチャーにセットして FirebaseUI を起動
            val signInIntent = AuthUI.getInstance()
                .createSignInIntentBuilder()
                .setAvailableProviders(providers)
                .build()
            signInLauncher.launch(signInIntent)

        }
    }

    // FirebaseUI のランチャー設定
    private val signInLauncher = registerForActivityResult(
        FirebaseAuthUIActivityResultContract()
    ) { res ->
        this.onSignInResult(res)
    }

    private fun onSignInResult(result: FirebaseAuthUIAuthenticationResult) {
        if (result.resultCode == RESULT_OK) {
            // 認証ユーザ情報の取得
            val user = FirebaseAuth.getInstance().currentUser
            // 認証出来ていれば次の画面遷移する
            user?.let {
                val nextIntent = Intent(this, UserActivity::class.java)
                nextIntent.putExtra("userName", it.displayName)
                nextIntent.putExtra("email", it.email)
                startActivity(nextIntent)
            }

        } else {
            // サインインに失敗しました。応答が null の場合、
            // ユーザーは [戻る] ボタンを使用してサインイン フローをキャンセルしました。
            // それ以外の場合は、response.getError().getErrorCode() を確認してエラーを
            // 処理してください。
            val response = result.idpResponse
            if(response == null){
                Toast.makeText(applicationContext, "認証がキャンセルされました",
                    Toast.LENGTH_SHORT).show()
            } else {
                response.error?.let{
                    Log.e("err",it.toString())
                 }
            }
        }
    }

}