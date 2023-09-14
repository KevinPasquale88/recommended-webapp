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

import { Comment } from '../models/comment';
import { Image } from '../models/image';

@Injectable({
  providedIn: 'root',
})
export class ImagingControllerService extends BaseService {
  constructor(
    config: ApiConfiguration,
    http: HttpClient
  ) {
    super(config, http);
  }

  /**
   * Path part for operation putComment
   */
  static readonly PutCommentPath = '/api/images/putComment';

  /**
   * This method provides access to the full `HttpResponse`, allowing access to response headers.
   * To access only the response body, use `putComment()` instead.
   *
   * This method sends `application/json` and handles request body of type `application/json`.
   */
  putComment$Response(params: {
    context?: HttpContext
    body: Comment
  }
): Observable<StrictHttpResponse<void>> {

    const rb = new RequestBuilder(this.rootUrl, ImagingControllerService.PutCommentPath, 'put');
    if (params) {
      rb.body(params.body, 'application/json');
    }

    return this.http.request(rb.build({
      responseType: 'text',
      accept: '*/*',
      context: params?.context
    })).pipe(
      filter((r: any) => r instanceof HttpResponse),
      map((r: HttpResponse<any>) => {
        return (r as HttpResponse<any>).clone({ body: undefined }) as StrictHttpResponse<void>;
      })
    );
  }

  /**
   * This method provides access to only to the response body.
   * To access the full response (for headers, for example), `putComment$Response()` instead.
   *
   * This method sends `application/json` and handles request body of type `application/json`.
   */
  putComment(params: {
    context?: HttpContext
    body: Comment
  }
): Observable<void> {

    return this.putComment$Response(params).pipe(
      map((r: StrictHttpResponse<void>) => r.body as void)
    );
  }

  /**
   * Path part for operation getRandomImage
   */
  static readonly GetRandomImagePath = '/api/images/random-image';

  /**
   * This method provides access to the full `HttpResponse`, allowing access to response headers.
   * To access only the response body, use `getRandomImage()` instead.
   *
   * This method doesn't expect any request body.
   */
  getRandomImage$Response(params?: {
    context?: HttpContext
  }
): Observable<StrictHttpResponse<Image>> {

    const rb = new RequestBuilder(this.rootUrl, ImagingControllerService.GetRandomImagePath, 'get');
    if (params) {
    }

    return this.http.request(rb.build({
      responseType: 'json',
      accept: 'application/json',
      context: params?.context
    })).pipe(
      filter((r: any) => r instanceof HttpResponse),
      map((r: HttpResponse<any>) => {
        return r as StrictHttpResponse<Image>;
      })
    );
  }

  /**
   * This method provides access to only to the response body.
   * To access the full response (for headers, for example), `getRandomImage$Response()` instead.
   *
   * This method doesn't expect any request body.
   */
  getRandomImage(params?: {
    context?: HttpContext
  }
): Observable<Image> {

    return this.getRandomImage$Response(params).pipe(
      map((r: StrictHttpResponse<Image>) => r.body as Image)
    );
  }

}
