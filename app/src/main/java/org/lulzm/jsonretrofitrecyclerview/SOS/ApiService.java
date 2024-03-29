package org.lulzm.jsonretrofitrecyclerview.SOS;

import retrofit2.Call;
import retrofit2.http.GET;

/*********************************************************
 *   $$\                  $$\             $$\      $$\   
 *   $$ |                 $$ |            $$$\    $$$ |  
 *   $$ |      $$\   $$\  $$ | $$$$$$$$\  $$$$\  $$$$ |  
 *   $$ |      $$ |  $$ | $$ | \____$$  | $$ \$\$$ $$ | 
 *   $$ |      $$ |  $$ | $$ |   $$$$ _/  $$  \$$  $$ |  
 *   $$ |      $$ |  $$ | $$ |  $$  _/    $$ | $  /$$ |  
 *   $$$$$$$$  \$$$$$$$ | $$ | $$$$$$$$\  $$ | \_/ $$ |  
 *   \_______| \______/   \__| \________| \__|     \__|  
 *
 * Project : JsonRetrofittest                             
 * Created by Android Studio                           
 * Developer : Lulz_M                                    
 * Date : 2019-06-05 005                                        
 * Time : 오후 12:39                                       
 * GitHub : https://github.com/scadasystems              
 * E-mail : redsmurf@lulzm.org                           
 *********************************************************/
public interface ApiService {
    @GET("emergency-json/db.json")
    Call<SosList> getMyJSON();
}
