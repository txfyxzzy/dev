from django.http import Http404, HttpResponse
from django.shortcuts import render
from django.shortcuts import render_to_response
from books.models import Book
# Create your views here.


def display_meta(request):
    values = request.META.items()
    #values.sort()
    html = []
    for k, v in values:
        html.append('<tr><td>%s</td><td>%s</td></tr>' % (k, v))
    return HttpResponse('<table>%s</table>' % '\n'.join(html))

def search_form(request):
    return render_to_response('search_form.html')

def search_1(request):
    if 'q' in request.GET:
        message = 'You searched for: %r' % request.GET['q']
        keys = request.GET.keys()
        html = []
        for k in keys:
            html.append('<tr><td>%s</td><td>%s</td></tr>' % (k, request.GET[k]))
        return HttpResponse('<table>%s</table>' % '\n'.join(html))
    else:
        message = 'You submitted an empty form.'
    return HttpResponse(message)

def search_2(request):
    if 'q' in request.GET and request.GET['q']:
        query = request.GET['q']
        books = Book.objects.filter(title__icontains=query)
        return render_to_response('search_results.html', {'books': books, 'query': query})

    else:
        message = 'You submitted an empty form.'
        return render_to_response('search_form.html', {'error': True})

def search(request):
    error = False
    if 'q' in request.GET:
        q = request.GET['q']
        if not q:
            error = True
        else:
            books = Book.objects.filter(title__icontains=q)
            return render_to_response('search_results.html',{'books': books, 'query': q})
    return render_to_response('search_form.html', {'error': error})