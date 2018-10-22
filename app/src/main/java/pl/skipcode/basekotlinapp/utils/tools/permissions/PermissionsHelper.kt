package pl.skipcode.basekotlinapp.utils.tools.permissions

import com.tbruyelle.rxpermissions2.RxPermissions
import io.reactivex.Observable
import pl.skipcode.basekotlinapp.feature.commons.ui.BaseActivity

class PermissionsHelper(
        private val activity: BaseActivity
) : PermissionsHelperInterface {
    override fun request(vararg permissions: String): Observable<Boolean> {
        return RxPermissions(activity).request(*permissions)
    }
}