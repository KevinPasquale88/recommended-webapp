/* tslint:disable */
/* eslint-disable */
import { Injectable } from '@angular/core';
import { HttpClient, HttpResponse, HttpContext } from '@angular/common/http';
import { BaseService } from '../base-service';
import { ApiConfiguration } from '../api-configuration';
import { StrictHttpResponse } from '../strict-http-response';
import { RequestBuilder } from '../request-builder';
import { Observable } from 'rxjs';
import { map, filter } from 'rxjs/operators';

import { AuthUser } from '../models/auth-user';
import { User } from '../models/user';

@Injectable({
  providedIn: 'root',
})
export class UserControllerService extends BaseService {
  constructor(
    config: ApiConfiguration,
    http: HttpClient
  ) {
    super(config, http);
  }

  /**
   * Path part for operation userSession
   */
  static readonly UserSessionPath = '/api/users/userSession';

  /**
   * This method provides access to the full `HttpResponse`, allowing access to response headers.
   * To access only the response body, use `userSession()` instead.
   *
   * This method sends `application/json` and handles request body of type `application/json`.
   */
  userSession$Response(params: {
    context?: HttpContext
    body: User
  }
): Observable<StrictHttpResponse<string>> {

    const rb = new RequestBuilder(this.rootUrl, UserControllerService.UserSessionPath, 'put');
    if (params) {
      rb.body(params.body, 'application/json');
    }

    return this.http.request(rb.build({
      responseType: 'text',
      accept: 'text/html',
      context: params?.context
    })).pipe(
      filter((r: any) => r instanceof HttpResponse),
      map((r: HttpResponse<any>) => {
        return r as StrictHttpResponse<string>;
      })
    );
  }

  /**
   * This method provides access to only to the response body.
   * To access the full response (for headers, for example), `userSession$Response()` instead.
   *
   * This method sends `application/json` and handles request body of type `application/json`.
   */
  userSession(params: {
    context?: HttpContext
    body: User
  }
): Observable<string> {

    return this.userSession$Response(params).pipe(
      map((r: StrictHttpResponse<string>) => r.body as string)
    );
  }

  /**
   * Path part for operation auth
   */
  static readonly AuthPath = '/api/users/auth';

  /**
   * This method provides access to the full `HttpResponse`, allowing access to response headers.
   * To access only the response body, use `auth()` instead.
   *
   * This method sends `application/json` and handles request body of type `application/json`.
   */
  auth$Response(params: {
    context?: HttpContext
    body: AuthUser
  }
): Observable<StrictHttpResponse<string>> {

    const rb = new RequestBuilder(this.rootUrl, UserControllerService.AuthPath, 'put');
    if (params) {
      rb.body(params.body, 'application/json');
    }

    return this.http.request(rb.build({
      responseType: 'text',
      accept: 'text/html',
      context: params?.context
    })).pipe(
      filter((r: any) => r instanceof HttpResponse),
      map((r: HttpResponse<any>) => {
        return r as StrictHttpResponse<string>;
      })
    );
  }

  /**
   * This method provides access to only to the response body.
   * To access the full response (for headers, for example), `auth$Response()` instead.
   *
   * This method sends `application/json` and handles request body of type `application/json`.
   */
  auth(params: {
    context?: HttpContext
    body: AuthUser
  }
): Observable<string> {

    return this.auth$Response(params).pipe(
      map((r: StrictHttpResponse<string>) => r.body as string)
    );
  }

}
